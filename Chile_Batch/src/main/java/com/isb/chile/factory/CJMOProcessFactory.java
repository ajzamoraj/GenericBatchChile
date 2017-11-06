package com.isb.chile.factory;

import org.springframework.stereotype.Service;

@Service
public class CJMOProcessFactory extends ProcessAbstractFactory {

    final static String CJMO = "CJMO"; 
    
	@Override
	public String getFactoryId() {
		return CJMO;
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
