package br.com.franca.controller.exception.dto;

public class StandartErrorDTO {
	
	protected String path;
	protected Integer status;
	protected Long timestamp;
	protected String error;
	protected String message;
	
	public String getPath() {
		return path;
	}
	public Integer getStatus() {
		return status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
	
	
}
