package com.bp.msdevops.enumeration;

/**
 * 
 * @author pedroalexandertenezaca
 *
 */
public enum EstadoApiResponseEnum {
	OK("OK", "ESTADO SATISFACTORIO"),ERROR("ERROR", "ERROR EN EJECUCION");

	private String code;
	private String descripcion;

	private EstadoApiResponseEnum(String code, String descripcion) {
		this.code = code;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getCode() {
		return this.code;
	}

}
