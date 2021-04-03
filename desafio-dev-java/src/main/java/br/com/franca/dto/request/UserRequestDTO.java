package br.com.franca.dto.request;

import java.time.LocalDate;

import br.com.franca.domain.Genre;

public class UserRequestDTO {

	private String name;
	private Genre genre;
	private String email;
	private LocalDate birthDate;
	private String naturalness;
	private String nationality;
	private String cpf;

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

	@Override
	public String toString() {
		return "UserRequestDTO [name=" + name + ", genre=" + genre + ", email=" + email + ", birthDate=" + birthDate
				+ ", naturalness=" + naturalness + ", nationality=" + nationality + ", cpf=" + cpf + "]";
	}

}
