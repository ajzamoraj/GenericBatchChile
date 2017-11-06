package com.isb.chile.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.isb.chile.bean.ConfigProcesoNegocio;
import com.isb.chile.bean.Parametro;

@Service
public abstract class ProcessAbstractFactory {
	
	// Método para identificar la factoria.
	public abstract String getFactoryId();

	public boolean processFile(String[] params, ConfigProcesoNegocio configProcesoNegocio){
		// Map con los parámetros que se leeran del fichero.
		Map<String, String> parameters = new HashMap<String, String>();
		readFile(configProcesoNegocio, parameters);
		return true;
		
	}
	
	
	public void readFile(ConfigProcesoNegocio configProcesoNegocio, Map<String, String> parameters){
		String fileLine="0016336311900000000800058162480012016-11-23 17:00:09";
		// TODO Abrir el fichero indicado en la configuracion.
		// TODO Leer cada linea del fichero.
		// TODO Leer cada parámetro de la linea.
		
		for (Parametro param : configProcesoNegocio.getParametros()) {
			// Ejemplo de lectura:
//			readParameter(fileLine, "idSolicitud", Integer.parseInt(configProcesoNegocio.getIdSolicitud()[0]),Integer.parseInt(configProcesoNegocio.getIdSolicitud()[1]),parameters);
			readParameter(fileLine, param.getNomParam(), param.getInicio(),param.getFin(),parameters);
		} 
	}
	
	/*
	 * Lee el parámetro indicado de la linea y lo guarda en el Map.
	 */ 
	protected void readParameter(String line, String paramName, int startIndex, int endIndex, Map<String, String> parameters){
		parameters.put(paramName, line.substring(startIndex,endIndex));
	}
	
	
	// TODO Recuperar el idSolicitud
	public abstract String recoverIdSolicitud();
	
	
	// TODO Procesar la informacion.
	public abstract void processFileData();
	
	
	public void writeFile(){
		// TODO Escribir el resultado en el fichero de salida.
		
	}
	
}
