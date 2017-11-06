package com.isb.chile.bean;

import lombok.Data;

@Data
public class ConfigProcesoNegocio {
	
	private String rutaEntrada;
	private String rutaSalida;
	
	private String nombre;
	//TODO: Revisar si conviene convertirlo en una lista de parámetros.
	private String[] idSolicitud;
	

}
