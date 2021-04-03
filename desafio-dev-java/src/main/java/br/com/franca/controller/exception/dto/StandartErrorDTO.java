package br.com.franca.controller.exception.dto;

public class StandartErrorDTO {

	protected String path;
	protected Integer status;
	protected Long timestamp;
	protected String error;
	protected String message;

	protected StandartErrorDTO(String path, Integer status, Long timestamp, 
			String error, String message) {
		
		this.path = path;
		this.status = status;
		this.timestamp = timestamp;
		this.error = error;
		this.message = message;
	}

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

	public static class StandartErrorBuilder {

		protected String message;
		protected String error;
		protected String path;
		protected Integer status;
		protected Long timestamp;

		public StandartErrorBuilder message(String message) {
			this.message = message;
			return this;
		}

		public StandartErrorBuilder error(String error) {
			this.error = error;
			return this;
		}

		public StandartErrorBuilder path(String path) {
			this.path = path;
			return this;
		}

		public StandartErrorBuilder status(Integer status) {
			this.status = status;
			return this;
		}

		public StandartErrorBuilder timestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public StandartErrorDTO buildStandartErrorDTO() {
			return new StandartErrorDTO(this.path, this.status, this.timestamp, this.error, this.message);
		}

	}

}
