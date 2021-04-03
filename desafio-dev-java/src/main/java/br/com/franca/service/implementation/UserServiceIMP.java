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
				
		if (dto.getName()==null) {
			throw new IllegalArgumentException("Nome não deve ser vazio");
		}
		
		if (dto.getBirthDate()==null) {
			throw new IllegalArgumentException("Data de Nascimento não deve ser vazio");
		}
		
		if (dto.getCpf()==null) {
			throw new IllegalArgumentException("CPF não deve ser vazio");
		}
		
		User user = dto.toUser();
		return repository.save(user).getId();
	}

}
