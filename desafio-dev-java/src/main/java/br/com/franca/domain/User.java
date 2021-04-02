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

@Table(name = "TB_USER", 
uniqueConstraints = { @UniqueConstraint(columnNames = { "cpf" }, name = "UK_TB_USER_CPF") })

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

}
