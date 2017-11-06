package com.isb.chile.factory;

import org.springframework.stereotype.Service;

@Service
public class CJPYMEProcessFactory extends ProcessAbstractFactory {

    final static String CJPYME = "CJPYME"; 
	
	@Override
	public String getFactoryId() {
		return CJPYME;
	}

	@Override
	public String recoverIdSolicitud() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processFileData() {
		// TODO Auto-generated method stub
		
	}

}
