package br.com.franca.controller.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.franca.controller.exception.dto.FormErrorDTO;
import br.com.franca.controller.exception.dto.StandartErrorDTO;
import br.com.franca.controller.exception.dto.StandartErrorDTO.StandartErrorBuilder;
import br.com.franca.service.exception.ResourceAlreadyExistsException;
import br.com.franca.service.exception.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	private MessageSource messageSource;

	public ControllerExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<StandartErrorDTO> handlerConstraintViolation(MethodArgumentNotValidException e,
			HttpServletRequest request) {

		List<StandartErrorDTO> standardErrorList = new ArrayList<>();

		List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();

		fieldErrorList.forEach((fildError) -> {

			String message = messageSource.getMessage(fildError, LocaleContextHolder.getLocale());

			StandartErrorBuilder standartErrorBuilder = new StandartErrorDTO.StandartErrorBuilder();

			StandartErrorDTO standartErrorDTO = standartErrorBuilder.message(message)
					.error("Restrição de dados")
					.path(request.getRequestURI())
					.status(HttpStatus.BAD_REQUEST.value())
					.timestamp(System.currentTimeMillis())
					.buildStandartErrorDTO();

			FormErrorDTO formErrorDTO = new FormErrorDTO.FormErrorBuilder()
					.field(fildError.getField())
					.buildFormErrorDTO(standartErrorDTO);

			standardErrorList.add(formErrorDTO);

		});

		return standardErrorList;

	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public StandartErrorDTO handlerIllegalArgument(IllegalArgumentException e, HttpServletRequest request) {
		
		StandartErrorDTO standartErrorDTO = new StandartErrorDTO.StandartErrorBuilder()
		.message(e.getMessage())
		.error("Argumento Inválido")
		.path(request.getRequestURI())
		.status(HttpStatus.BAD_REQUEST.value())
		.timestamp(System.currentTimeMillis())
		.buildStandartErrorDTO();
		
		return standartErrorDTO;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public StandartErrorDTO handlerResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
		
		StandartErrorDTO standartErrorDTO = new StandartErrorDTO.StandartErrorBuilder()
		.message(e.getMessage())
		.error("Recurso não encontrado")
		.path(request.getRequestURI())
		.status(HttpStatus.NOT_FOUND.value())
		.timestamp(System.currentTimeMillis())
		.buildStandartErrorDTO();
		
		return standartErrorDTO;
	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public StandartErrorDTO handlerResourceAlreadyExists(ResourceAlreadyExistsException e, HttpServletRequest request) {
		
		StandartErrorDTO standartErrorDTO = new StandartErrorDTO.StandartErrorBuilder()
		.message(e.getMessage())
		.error("Regra de Negócio")
		.path(request.getRequestURI())
		.status(HttpStatus.CONFLICT.value())
		.timestamp(System.currentTimeMillis())
		.buildStandartErrorDTO();
		
		return standartErrorDTO;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public StandartErrorDTO handlerDataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
		
		StandartErrorDTO standartErrorDTO = new StandartErrorDTO.StandartErrorBuilder()
		.message(e.getMessage())
		.error("Integridade de dados")
		.path(request.getRequestURI())
		.status(HttpStatus.BAD_REQUEST.value())
		.timestamp(System.currentTimeMillis())
		.buildStandartErrorDTO();
		
		return standartErrorDTO;
	}	
		
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public StandartErrorDTO handlerBadCredentialsException(AuthenticationException e, HttpServletRequest request) {
		
		StandartErrorDTO standartErrorDTO = new StandartErrorDTO.StandartErrorBuilder()
		.message(e.getMessage())
		.error("Dados inválidos")
		.path(request.getRequestURI())
		.status(HttpStatus.UNAUTHORIZED.value())
		.timestamp(System.currentTimeMillis())
		.buildStandartErrorDTO();
		
		return standartErrorDTO;
	}
	
	@ExceptionHandler(JwtException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public StandartErrorDTO handlerBadCredentialsException(JwtException e, HttpServletRequest request) {
		
		StandartErrorDTO standartErrorDTO = new StandartErrorDTO.StandartErrorBuilder()
		.message(e.getMessage())
		.error("Erro de Token")
		.path(request.getRequestURI())
		.status(HttpStatus.UNAUTHORIZED.value())
		.timestamp(System.currentTimeMillis())
		.buildStandartErrorDTO();
		
		return standartErrorDTO;
	}
	
	

}
