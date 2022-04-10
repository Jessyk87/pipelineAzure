package com.bp.msdevops.domain.exception;

import com.bp.msdevops.domain.enumeration.*;
import com.bp.msdevops.dto.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ManejoExcepciones {
	
	private String nombreClase;
	
	private final Logger logger = LoggerFactory.getLogger(ManejoExcepciones.class);
	
	public ManejoExcepciones(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	public ApiResponse registraLogExcepcionRest(Exception ex, String estadoError) {		
		String mensaje = mensajeEstandarError(ex, estadoError);
		mostrarMensajeErrorEnConsola(ex, mensaje);
		return new ApiResponse(EstadoApiResponseEnum.ERROR.getCode(), EstadoApiResponseEnum.ERROR.getDescripcion());		
	}
	
	private String mensajeEstandarError(Exception ex, String estadoError) {
		return "Clase Padre: " + nombreClase + " \n"
				+ "Método : " + ex.getStackTrace()[0].getClassName()  + "." 
				+ ex.getStackTrace()[0].getMethodName() + "\n" 
				+ "Error: " + estadoError + " " + ex.toString();
	}
	
	private void mostrarMensajeErrorEnConsola(Exception ex, String mensaje) {
		if (!mensaje.contains(EstadoErrorEnum.VALIDACION.getCode())) {			
			logger.error(mensaje, ex);
		}
	}
	
	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
}
