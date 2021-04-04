package br.com.franca.service.dto;

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
	protected String name;
	
	protected Genre genre;

	@Length(max = 50)
	@Email
	protected String email;

	@NotNull
	@PastOrPresent
	protected LocalDate birthDate;

	@Length(max = 30)
	protected String naturalness;
	
	@Length(max = 20)
	protected String nationality;
	
	@NotNull
	@NotEmpty
	@Length(min =11, max = 11)
	protected String cpf;

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

	public void setName(String name) {
		this.name = name;
	}

}
