package sts;

import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.validate.Credential;
import org.apache.wss4j.dom.validate.Validator;

public class SimpleValidator implements Validator {

	@Override
	public Credential validate(Credential credential, RequestData data)
			throws WSSecurityException {
		return credential;
	}

}
