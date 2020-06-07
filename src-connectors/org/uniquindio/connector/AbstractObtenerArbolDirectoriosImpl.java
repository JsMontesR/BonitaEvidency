/**
 * 
 */
package org.uniquindio.connector;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

/**
 * This abstract class is generated and should not be modified.
 */
public abstract class AbstractObtenerArbolDirectoriosImpl extends AbstractConnector {

	protected final static String FOLDER_PATH_INPUT_PARAMETER = "folder_path";
	protected final static String ATOMPUB_INPUT_PARAMETER = "atompub";
	protected final static String WEBSERVICES_INPUT_PARAMETER = "webservices";
	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String REPOSITORY_INPUT_PARAMETER = "repository";
	protected final static String BINDING_TYPE_INPUT_PARAMETER = "binding_type";
	protected final static String WSOBJECTSERVICEURL_INPUT_PARAMETER = "wsObjectServiceUrl";
	protected final static String WSOBJECTSERVICEENDPOINTURL_INPUT_PARAMETER = "wsObjectServiceEndpointUrl";
	protected final static String WSREPOSITORYSERVICEURL_INPUT_PARAMETER = "wsRepositoryServiceUrl";
	protected final static String WSREPOSITORYSERVICEENDPOINTURL_INPUT_PARAMETER = "wsRepositoryServiceEndpointUrl";
	protected final static String WSVERSIONINGSERVICEURL_INPUT_PARAMETER = "wsVersioningServiceUrl";
	protected final static String WSVERSIONINGSERVICEENDPOINTURL_INPUT_PARAMETER = "wsVersioningServiceEndpointUrl";
	protected final static String WSNAVIGATIONSERVICEURL_INPUT_PARAMETER = "wsNavigationServiceUrl";
	protected final static String WSNAVIGATIONSERVICEENDPOINTURL_INPUT_PARAMETER = "wsNavigationServiceEndpointUrl";
	protected final static String USERNAME_INPUT_PARAMETER = "username";
	protected final static String PASSWORD_INPUT_PARAMETER = "password";
	protected final String DIR_TREE_OUTPUT_PARAMETER = "dir_tree";

	protected final java.lang.String getFolder_path() {
		return (java.lang.String) getInputParameter(FOLDER_PATH_INPUT_PARAMETER);
	}

	protected final java.lang.String getAtompub() {
		return (java.lang.String) getInputParameter(ATOMPUB_INPUT_PARAMETER);
	}

	protected final java.lang.String getWebservices() {
		return (java.lang.String) getInputParameter(WEBSERVICES_INPUT_PARAMETER);
	}

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	}

	protected final java.lang.String getRepository() {
		return (java.lang.String) getInputParameter(REPOSITORY_INPUT_PARAMETER);
	}

	protected final java.lang.String getBinding_type() {
		return (java.lang.String) getInputParameter(BINDING_TYPE_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsObjectServiceUrl() {
		return (java.lang.String) getInputParameter(WSOBJECTSERVICEURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsObjectServiceEndpointUrl() {
		return (java.lang.String) getInputParameter(WSOBJECTSERVICEENDPOINTURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsRepositoryServiceUrl() {
		return (java.lang.String) getInputParameter(WSREPOSITORYSERVICEURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsRepositoryServiceEndpointUrl() {
		return (java.lang.String) getInputParameter(WSREPOSITORYSERVICEENDPOINTURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsVersioningServiceUrl() {
		return (java.lang.String) getInputParameter(WSVERSIONINGSERVICEURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsVersioningServiceEndpointUrl() {
		return (java.lang.String) getInputParameter(WSVERSIONINGSERVICEENDPOINTURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsNavigationServiceUrl() {
		return (java.lang.String) getInputParameter(WSNAVIGATIONSERVICEURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getWsNavigationServiceEndpointUrl() {
		return (java.lang.String) getInputParameter(WSNAVIGATIONSERVICEENDPOINTURL_INPUT_PARAMETER);
	}

	protected final java.lang.String getUsername() {
		return (java.lang.String) getInputParameter(USERNAME_INPUT_PARAMETER);
	}

	protected final java.lang.String getPassword() {
		return (java.lang.String) getInputParameter(PASSWORD_INPUT_PARAMETER);
	}

	protected final void setDir_tree(org.apache.chemistry.opencmis.commons.impl.json.JSONObject dir_tree) {
		setOutputParameter(DIR_TREE_OUTPUT_PARAMETER, dir_tree);
	}

	@Override
	public void validateInputParameters() throws ConnectorValidationException {
		try {
			getFolder_path();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("folder_path type is invalid");
		}
		try {
			getAtompub();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("atompub type is invalid");
		}
		try {
			getWebservices();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("webservices type is invalid");
		}
		try {
			getUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("url type is invalid");
		}
		try {
			getRepository();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("repository type is invalid");
		}
		try {
			getBinding_type();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("binding_type type is invalid");
		}
		try {
			getWsObjectServiceUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsObjectServiceUrl type is invalid");
		}
		try {
			getWsObjectServiceEndpointUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsObjectServiceEndpointUrl type is invalid");
		}
		try {
			getWsRepositoryServiceUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsRepositoryServiceUrl type is invalid");
		}
		try {
			getWsRepositoryServiceEndpointUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsRepositoryServiceEndpointUrl type is invalid");
		}
		try {
			getWsVersioningServiceUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsVersioningServiceUrl type is invalid");
		}
		try {
			getWsVersioningServiceEndpointUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsVersioningServiceEndpointUrl type is invalid");
		}
		try {
			getWsNavigationServiceUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsNavigationServiceUrl type is invalid");
		}
		try {
			getWsNavigationServiceEndpointUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("wsNavigationServiceEndpointUrl type is invalid");
		}
		try {
			getUsername();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("username type is invalid");
		}
		try {
			getPassword();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("password type is invalid");
		}

	}

}
