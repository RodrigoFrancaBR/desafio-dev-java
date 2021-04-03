package br.com.franca.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "TB_USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "cpf" }, name = "UK_TB_USER_CPF") })

@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Genre genre;

	@Column(length = 50)
	private String email;

	@Column(nullable = false)
	private LocalDate birthDate;

	@Column(length = 30)
	private String naturalness;

	@Column(length = 20)
	private String nationality;

	@Column(nullable = false, length = 11)
	private String cpf;	

	private User(String name, Genre genre, String email, LocalDate birthDate,
			String naturalness, String nationality,String cpf) {
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

	public static class UserBuilder {
		private String name;
		private Genre genre;
		private String email;
		private LocalDate birthDate;
		private String naturalness;
		private String nationality;
		private String cpf;

		public UserBuilder(String name, LocalDate birthDate, String cpf) {
			this.name = name;
			this.birthDate = birthDate;
			this.cpf = cpf;
		}


		public UserBuilder genre(Genre genre) {
			this.genre = genre;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		

		public UserBuilder naturalness(String naturalness) {
			this.naturalness = naturalness;
			return this;
		}

		public UserBuilder nationality(String nationality) {
			this.nationality = nationality;
			return this;
		}
/*		
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}


		public UserBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}
*/
		public User buildUser() {
			return new User(this.name, this.genre, this.email, this.birthDate,
					this.naturalness, this.nationality,this.cpf);
		}

	}


}