package br.com.franca.service.implementation;

import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.dto.request.UserRequestDTO;
import br.com.franca.repository.UserRepository;
import br.com.franca.service.interfaces.UserService;

@Service
public class UserServiceIMP implements UserService {
	
	private UserRepository repository;	

	public UserServiceIMP(UserRepository repository) {
		this.repository = repository;	
	}

	@Override
	public Long save(UserRequestDTO dto) {
		
		User user = new User.UserBuilder(dto.getName(),
				dto.getBirthDate(),
				dto.getCpf())				
		.genre(dto.getGenre())
		.email(dto.getEmail())
		.naturalness(dto.getNaturalness())
		.nationality(dto.getNationality())
		.buildUser();
		
		return repository.save(user).getId();
	}

}
