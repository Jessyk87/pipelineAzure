package com.bp.msdevops.domain.enumeration;

public enum EstadoErrorEnum {

	VALIDACION("ERROR_VALIDACION", "ERROR VALIDACION"), EJECUCION("ERROR_EJECUCION", "ERROR EN EJECUCION");

	private String code;
	private String descripcion;

	private EstadoErrorEnum(String code, String descripcion) {
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

