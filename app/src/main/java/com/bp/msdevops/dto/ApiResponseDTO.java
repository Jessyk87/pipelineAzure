package com.bp.msdevops.dto;

/**
 * 
 * @author pedroalexandertenezaca
 *
 */
public class ApiResponseDTO {

	private String status;
	private String message;

	private Object objeto;

	public ApiResponseDTO(String status, Object objeto) {
		this.status = status;
		this.objeto = objeto;
	}

	public ApiResponseDTO(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

