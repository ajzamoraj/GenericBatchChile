package com.isb.chile.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.isb.chile.bean.ConfigProcesoNegocio;

import lombok.Data;


@Data
@Configuration
@ConfigurationProperties(prefix="configuration")
public class ConfigProcesosNegocio {

	private String ruta;
	private List<ConfigProcesoNegocio> procesosNegocio = new ArrayList<ConfigProcesoNegocio>();
	
    public List<ConfigProcesoNegocio> getProcesosNegocio() {
        return this.procesosNegocio;
    }

	
}
