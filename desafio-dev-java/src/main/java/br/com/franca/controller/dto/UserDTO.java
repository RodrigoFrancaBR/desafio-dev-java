package br.com.franca.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import br.com.franca.domain.Genre;
import br.com.franca.domain.User;
import br.com.franca.domain.User.UserBuilder;

public class UserDTO {
	
	@NotNull
	@NotEmpty
	@Length( max = 50)	
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
	@Length(max = 11)
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

	public User toUser() {
		UserBuilder userBuilder = new User.UserBuilder(this.name, this.birthDate, this.cpf);
		return userBuilder.genre(this.genre).email(this.email).naturalness(this.naturalness)
				.nationality(this.nationality).buildUser();
	}

	@Override
	public String toString() {
		return "UserRequestDTO [name=" + name + ", genre=" + genre + ", email=" + email + ", birthDate=" + birthDate
				+ ", naturalness=" + naturalness + ", nationality=" + nationality + ", cpf=" + cpf + "]";
	}

}
