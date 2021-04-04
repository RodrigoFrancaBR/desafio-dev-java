package br.com.franca.service.dto.out;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.franca.domain.Genre;
import br.com.franca.service.dto.UserDTO;

public class UserResponseDTO extends UserDTO {

	@NotNull
	private Long id;	

	private UserResponseDTO(Long id, String name, Genre genre, String email,
			LocalDate birthDate, String naturalness, String nationality, String cpf) {
				this.id = id;
				this.name = name;
				this.genre = genre;
				this.email = email;
				this.birthDate = birthDate;
				this.naturalness = naturalness;
				this.nationality = nationality;
				this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public static class UserResponseDTOBuilder {
		private Long id;
		private String name;
		private Genre genre;
		private String email;
		private LocalDate birthDate;
		private String naturalness;
		private String nationality;
		private String cpf;

		public UserResponseDTOBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public UserResponseDTOBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UserResponseDTOBuilder genre(Genre genre) {
			this.genre = genre;
			return this;
		}

		public UserResponseDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserResponseDTOBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public UserResponseDTOBuilder naturalness(String naturalness) {
			this.naturalness = naturalness;
			return this;
		}

		public UserResponseDTOBuilder nationality(String nationality) {
			this.nationality = nationality;
			return this;
		}

		public UserResponseDTOBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public UserResponseDTO buildUserResponseDTO() {
			return new UserResponseDTO(id, name, genre, email, birthDate, naturalness, nationality, cpf);
		}

	}

}
