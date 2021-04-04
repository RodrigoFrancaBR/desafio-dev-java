package br.com.franca.service.exception;

public class ResourceNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
