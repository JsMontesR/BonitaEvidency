/**
 * @author Jhon Sebastian Montes R
 */

/**
 * Copyright (C) 2013 BonitaSoft S.A.
 * BonitaSoft, 31 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
*The connector execution will follow the steps
* 1 - setInputParameters() --> the connector receives input parameters values
* 2 - validateInputParameters() --> the connector can validate input parameters values
* 3 - connect() --> the connector can establish a connection to a remote server (if necessary)
* 4 - executeBusinessLogic() --> execute the connector
* 5 - getOutputParameters() --> output are retrieved from connector
* 6 - disconnect() --> the connector can close connection to remote server (if any)
*/

package org.uniquindio.connector;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.FileableCmisObject;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.OperationContext;
import org.apache.chemistry.opencmis.client.api.Tree;
import org.apache.chemistry.opencmis.client.runtime.OperationContextImpl;
import org.apache.chemistry.opencmis.commons.enums.BaseTypeId;
import org.apache.chemistry.opencmis.commons.enums.IncludeRelationships;
import org.apache.chemistry.opencmis.commons.impl.json.JSONArray;
import org.apache.chemistry.opencmis.commons.impl.json.JSONObject;
import org.bonitasoft.connectors.cmis.AbstractCMISConnector;
import org.bonitasoft.connectors.cmis.cmisclient.AbstractCmisClient;
import org.bonitasoft.engine.connector.ConnectorException;
import java.util.List;

public class ObtenerArbolDirectoriosImpl extends AbstractCMISConnector {

    public static final String FOLDER_PATH = "folder_path";

    public static final String ARBOL = "dir_tree";
    
    private Logger logger = Logger.getLogger("org.bonitasoft");

    private String folderPath;
    
    
    @Override
    public void executeBusinessLogic() throws ConnectorException {
        final AbstractCmisClient cmisClient = getClient();
        
        try {
            if (cmisClient != null) {
            	logger.info("Recuperando árbol de directorios del RVI");
            	OperationContext oc = new OperationContextImpl();
            	oc.setFilterString("cmis:name");
            	oc.setIncludeAcls(false);
            	oc.setIncludeAllowableActions(false);
            	oc.setIncludePolicies(false);
            	oc.setIncludeRelationships(IncludeRelationships.NONE);
            	oc.setRenditionFilterString("cmis:none");
            	oc.setCacheEnabled(true);
            	oc.setIncludePathSegments(false);
            	oc.setLoadSecondaryTypeProperties(false);
            	Folder folder = cmisClient.getFolderByPath(folderPath);
            	List<Tree<FileableCmisObject>>  l = folder.getFolderTree(-1, oc);
            	logger.info("Creando árbol JSON de directorios del RVI");
            	JSONObject root = new JSONObject();
            	JSONArray childs = new JSONArray();
            	for (Tree<FileableCmisObject> tree : l) {
					childs.add(recorrerArbol(tree, cmisClient, new JSONObject()));
				}
            	root.put("text", folder.getName());
            	root.put("path", folder.getPath());
            	root.put("children", childs);
            	logger.info("Se cargó el árbol de directorios");
            	setOutputParameter(ARBOL, root);
            }else {
            	throw new ConnectorException("Fallo de conexión al cliente CMIS");
            }
        } catch (Exception e) {
        	logger.warning(e.getMessage());
		}finally {
            if (!getOutputParameters().containsKey(ARBOL)) {
                setOutputParameter(ARBOL, null);
            }
        }
    }
    
    /**
     * Método recursivo que recorre el Arbol retornado del directorio base
     * @param tree arbol a recorrer, "Hace las veces de nodo"
     * @param cmisClient cliente cmis
     * @param parent Objecto JSON o nodo JSON al cual se transferirá el arbol
     * @return JSONObject un nodo JSON con sus hijos en formato JSON
     */
    public JSONObject recorrerArbol(Tree<FileableCmisObject> tree, AbstractCmisClient cmisClient, JSONObject parent) {
    	
    	parent.put("text", tree.getItem().getName());
    	JSONArray children = new JSONArray();

    	if(!tree.getChildren().isEmpty()) {
    		for (Tree<FileableCmisObject> arbolHijo : tree.getChildren()) {
				children.add(recorrerArbol(arbolHijo, cmisClient, new JSONObject()));
			}
    	}
    	
    	parent.put("children", children);
    	
    	return parent;
    	
    }
    
    @Override
    public void setInputParameters(final Map<String, Object> parameters) {
        super.setInputParameters(parameters);
        folderPath = (String) parameters.get(FOLDER_PATH);
        logger.log(Level.ALL, FOLDER_PATH);
    }
}




