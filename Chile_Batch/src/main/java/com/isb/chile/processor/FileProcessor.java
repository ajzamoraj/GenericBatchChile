package com.isb.chile.processor;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.chile.Application;
import com.isb.chile.bean.ConfigProcesoNegocio;
import com.isb.chile.config.ConfigProcesosNegocio;
import com.isb.chile.factory.ProcessAbstractFactory;
import com.isb.chile.factory.ProcessFactoryProducer;

@Service
public class FileProcessor {
	
	static final Logger LOGGER = Logger.getLogger(FileProcessor.class);
	
	@Autowired
	private ConfigProcesosNegocio procesosNegocio;
	
	@Autowired
	ProcessFactoryProducer processFactoryProducer;
	
	public void processFile(String[] params) {
		
		String processID = params[0];
		String ruta = procesosNegocio.getRuta();
		List<ConfigProcesoNegocio> procesos = procesosNegocio.getProcesosNegocio();
		
		// Para identificar que tipo de procesamiento es, nos llega como parámetro de entrada.
		for (ConfigProcesoNegocio configProcesoNegocio : procesos) {
			if(!StringUtils.isEmpty(processID) && processID.equals(configProcesoNegocio.getNombre())){
				// Recupera el Factory correspondiente al procesamiento a partir de los parámetros
				ProcessAbstractFactory factory = processFactoryProducer.getProcessFactory(configProcesoNegocio.getNombre());
				
				if(factory==null){
					LOGGER.error("No se reconoce el proceso correspondiente al nombre " + configProcesoNegocio.getNombre());
				}else{
					// Lanza la ejecucion del Factory
					factory.processFile(params, configProcesoNegocio);				
				}
			}
		}
		
	}

}
