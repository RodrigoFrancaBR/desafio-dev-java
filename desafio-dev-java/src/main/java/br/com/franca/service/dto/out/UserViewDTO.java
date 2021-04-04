package br.com.franca.service.dto.out;

import java.time.LocalDate;

import br.com.franca.domain.Genre;

public class UserViewDTO {
	
	private Long id;
	private String name;
	private Genre genre;
	private String email;
	private LocalDate birthDate;
	private String naturalness;
	private String nationality;
	private String cpf;		

	public Long getId() {
		return id;
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

	private UserViewDTO(Long id, String name, Genre genre, String email, LocalDate birthDate, String naturalness,
			String nationality, String cpf) {		
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.email = email;
		this.birthDate = birthDate;
		this.naturalness = naturalness;
		this.nationality = nationality;
		this.cpf = cpf;
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
