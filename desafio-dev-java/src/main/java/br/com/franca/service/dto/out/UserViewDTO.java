package br.com.franca.service.dto.out;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.franca.domain.Genre;
import br.com.franca.service.dto.in.UserFrontDTO;

public class UserViewDTO extends UserFrontDTO {

	@NotNull
	private Long id;	

	private UserViewDTO(Long id, String name, Genre genre, String email,
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

	public static class UserViewDTOBuilder {
		private Long id;
		private String name;
		private Genre genre;
		private String email;
		private LocalDate birthDate;
		private String naturalness;
		private String nationality;
		private String cpf;

		public UserViewDTOBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public UserViewDTOBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UserViewDTOBuilder genre(Genre genre) {
			this.genre = genre;
			return this;
		}

		public UserViewDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserViewDTOBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public UserViewDTOBuilder naturalness(String naturalness) {
			this.naturalness = naturalness;
			return this;
		}

		public UserViewDTOBuilder nationality(String nationality) {
			this.nationality = nationality;
			return this;
		}

		public UserViewDTOBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public UserViewDTO buildUserViewDTO() {
			return new UserViewDTO(id, name, genre, email, birthDate, naturalness, nationality, cpf);
		}

	}

}
