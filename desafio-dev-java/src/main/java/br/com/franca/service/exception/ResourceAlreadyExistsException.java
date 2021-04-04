package br.com.franca.service.exception;

public class ResourceAlreadyExistsException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException(String message) {
		super(message);
	}

}
