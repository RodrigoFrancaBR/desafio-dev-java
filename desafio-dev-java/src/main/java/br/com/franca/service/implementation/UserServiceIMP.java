package br.com.franca.service.implementation;

import org.springframework.stereotype.Service;

import br.com.franca.controller.dto.UserDTO;
import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;
import br.com.franca.service.interfaces.UserService;

@Service
public class UserServiceIMP implements UserService {
	
	private UserRepository repository;	

	public UserServiceIMP(UserRepository repository) {
		this.repository = repository;	
	}

	@Override
	public Long save(UserDTO dto) {
		User user = dto.toUser();
		return repository.save(user).getId();
	}

}
