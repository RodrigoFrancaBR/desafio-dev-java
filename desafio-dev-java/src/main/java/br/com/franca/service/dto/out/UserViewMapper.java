package br.com.franca.service.dto.out;

import br.com.franca.domain.User;

public class UserViewMapper {
	
	public UserViewDTO map(User user) {
		return new UserViewDTO.UserViewDTOBuilder()
		.id(user.getId())
		.name(user.getName())
		.genre(user.getGenre())
		.email(user.getEmail())
		.birthDate(user.getBirthDate())
		.naturalness(user.getNaturalness())
		.nationality(user.getNationality())
		.cpf(user.getCpf())
		.buildUserViewDTO();				
	}
}
