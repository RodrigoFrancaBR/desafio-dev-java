package br.com.franca.controller.exception.dto;

public class FormErrorDTO extends StandartErrorDTO {

	private String field;		

	private FormErrorDTO(String path, Integer status, Long timestamp,
			String error, String message, String field) {
		
		super(path, status, timestamp, error, message);
		
		this.field = field;
	}
	
	public String getField() {
		return field;
	}

	public static class FormErrorBuilder extends StandartErrorBuilder{

		private String field;

		public FormErrorBuilder field(String field) {
			this.field = field;
			return this;
		}
	
		public FormErrorDTO buildFormErrorDTO(StandartErrorDTO standartErrorDTO) {
			return new FormErrorDTO(standartErrorDTO.path, standartErrorDTO.status,
					standartErrorDTO.timestamp, standartErrorDTO.error, standartErrorDTO.message,
					this.field);			
		}

	}
}
