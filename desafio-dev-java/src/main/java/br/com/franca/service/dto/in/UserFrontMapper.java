package br.com.franca.service.dto.in;

import br.com.franca.domain.User;

public class UserFrontMapper {

	public User map(UserFrontDTO dto) {
		return new User.UserBuilder(dto.getName(), dto.getBirthDate(), dto.getCpf())
		.genre(dto.getGenre())
		.email(dto.getEmail())
		.naturalness(dto.getNaturalness())
		.nationality(dto.getNationality())
		.buildUser();
	}

}
