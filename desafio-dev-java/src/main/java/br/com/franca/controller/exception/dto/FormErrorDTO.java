package br.com.franca.controller.exception.dto;

public class FormErrorDTO extends StandartErrorDTO {

	private String field;

	private FormErrorDTO(String field, String path, Integer status, 
			Long timestamp, String error, String message) {
		this.field = field;
		this.path = path;
		this.status = status;
		this.timestamp = timestamp;
		this.error = error;
		this.message = message;
	}
		
	public String getField() {
		return field;
	}

	public static class FormErrorBuild {

		private String field;
		private String message;
		private String error;
		private String path;
		private Integer status;
		private Long timestamp;

		public FormErrorBuild field(String field) {
			this.field = field;
			return this;
		}

		public FormErrorBuild message(String message) {
			this.message = message;
			return this;
		}

		public FormErrorBuild error(String error) {
			this.error = error;
			return this;
		}

		public FormErrorBuild path(String path) {
			this.path = path;
			return this;
		}

		public FormErrorBuild status(Integer status) {
			this.status = status;
			return this;
		}

		public FormErrorBuild timestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public FormErrorDTO buildFormErrorDTO() {
			return new FormErrorDTO(this.field, this.path, this.status, 
					this.timestamp, this.error, this.message);
		}

	}
}
