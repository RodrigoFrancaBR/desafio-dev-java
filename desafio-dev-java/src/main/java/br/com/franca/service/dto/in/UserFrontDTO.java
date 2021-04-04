package br.com.franca.service.dto.in;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import br.com.franca.domain.Genre;

public class UserFrontDTO {

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String name;

	private Genre genre;

	@Length(max = 50)
	@Email
	private String email;

	@NotNull
	@PastOrPresent
	private LocalDate birthDate;

	@Length(max = 30)
	private String naturalness;

	@Length(max = 20)
	private String nationality;

	@NotNull
	@NotEmpty
	@Length(min = 11, max = 11)
	private String cpf;

	private UserFrontDTO(String name, Genre genre, String email, LocalDate birthDate, String naturalness,
			String nationality, String cpf) {
		this.name = name;
		this.genre = genre;
		this.email = email;
		this.birthDate = birthDate;
		this.naturalness = naturalness;
		this.nationality = nationality;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public Genre getGenre() {
		return genre;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getNaturalness() {
		return naturalness;
	}

	public String getNationality() {
		return nationality;
	}

	public String getCpf() {
		return cpf;
	}

	public static class UserFrontDTOBuilder {

		private String name;
		private LocalDate birthDate;
		private String cpf;
		private Genre genre;
		private String email;
		private String naturalness;
		private String nationality;

		public UserFrontDTOBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UserFrontDTOBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public UserFrontDTOBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public UserFrontDTOBuilder genre(Genre genre) {
			this.genre = genre;
			return this;
		}

		public UserFrontDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserFrontDTOBuilder naturalness(String naturalness) {
			this.naturalness = naturalness;
			return this;
		}

		public UserFrontDTOBuilder nationality(String nationality) {
			this.nationality = nationality;
			return this;
		}

		public UserFrontDTO buildUserFrontDTO() {
			return new UserFrontDTO(this.name, this.genre, this.email, this.birthDate, this.naturalness,
					this.nationality, this.cpf);
		}

	}

}
