package br.com.franca.domain;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDTO {
	
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsernamePasswordAuthenticationToken getAuthenticationToken() {
		return new UsernamePasswordAuthenticationToken(this.userName, this.password);
	}

}
