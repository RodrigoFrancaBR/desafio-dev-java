package br.com.franca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "TB_USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "cpf" }, name = "UK_TB_USER_CPF") })
@Entity
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

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

	private String userName;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Profiles> profiles = new ArrayList<>();
	
	private User(Long id, String name, Genre genre, String email, LocalDate birthDate, String naturalness,
			String nationality, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.email = email;
		this.birthDate = birthDate;
		this.naturalness = naturalness;
		this.nationality = nationality;
		this.cpf = cpf;
	}
	
	@Override
	public String getUsername() {
		return this.userName;
	}
	
	@Override
	public boolean isAccountNonExpired() {	
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {	
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {	
		return true;
	}
	
	@Override
	public boolean isEnabled() {	
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profiles;
	}

	public User() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {	
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
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

	public String getUserName() {
		return userName;
	}	
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class UserBuilder {
		private Long id;
		private String name;
		private Genre genre;
		private String email;
		private LocalDate birthDate;
		private String naturalness;
		private String nationality;
		private String cpf;
		
		public UserBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
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
				
		public User buildUser() {
			return new User(this.id, this.name, this.genre, this.email,
					this.birthDate, this.naturalness, this.nationality, this.cpf);
		}
		
	}

}
