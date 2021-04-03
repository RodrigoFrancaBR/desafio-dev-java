package br.com.franca.controller.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.franca.controller.exception.dto.FormErrorDTO;
import br.com.franca.controller.exception.dto.StandartErrorDTO;

@RestControllerAdvice
public class ControllerExceptionHandler {

	private MessageSource messageSource;

	public ControllerExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<StandartErrorDTO> handlerConstraintViolation(MethodArgumentNotValidException e, HttpServletRequest request) {

		List<StandartErrorDTO> standardErrorList = new ArrayList<>();

		List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();

		fieldErrorList.forEach((fildError) -> {

			String message = messageSource
					.getMessage(fildError, LocaleContextHolder.getLocale());
			
			FormErrorDTO formErrorDTO = new FormErrorDTO.FormErrorBuild()
			.field(fildError.getField())
			.message(message)
			.error("Restrição de dados")
			.path(request.getRequestURI())
			.status(HttpStatus.BAD_REQUEST.value())
			.timestamp(System.currentTimeMillis())
			.buildFormErrorDTO();
			
			standardErrorList.add(formErrorDTO);					

		});
		
		return standardErrorList;

	}
}
