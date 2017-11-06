package com.isb.chile.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ConfigProcesoNegocio {
	
	private String rutaEntrada;
	private String rutaSalida;
	
	private String nombre;
	private String[] idSolicitud;
	
	//TODO: Revisar si conviene convertirlo en una lista de parámetros.
	private List<Parametro> parametros = new ArrayList<Parametro>();
	
    public List<Parametro> getParametros() {
        return this.parametros;
    }
	
	

}
