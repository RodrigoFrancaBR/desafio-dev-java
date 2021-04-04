package br.com.franca.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;
import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.exception.ResourceAlreadyExistsException;
import br.com.franca.service.interfaces.UserService;

@Service
public class UserServiceIMP implements UserService {

	private UserRepository repository;

	public UserServiceIMP(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public Long save(UserDTO dto) {

		if (dto.getName() == null) {
			throw new IllegalArgumentException("Nome não deve ser vazio");
		}

		if (dto.getBirthDate() == null) {
			throw new IllegalArgumentException("Data de Nascimento não deve ser vazio");
		}

		if (dto.getCpf() == null) {
			throw new IllegalArgumentException("CPF não deve ser vazio");
		}

		if (!isCpf(dto.getCpf())) {
			throw new IllegalArgumentException("CPF deve conter 11 dígitos entre [0 e 9]");
		}

		Optional<User> optional = repository.findByCpf(dto.getCpf());

		if (optional.isPresent()) {
			throw new ResourceAlreadyExistsException("Já existe um Usuário com o cpf informado");
		}

		User user = dto.toUser();

		return repository.save(user).getId();
	}		

	private boolean isCpf(String cpf) {

		if (cpf.contains("-") || cpf.contains(".")) {
			return false;
		}
		
		if (cpf.length()!=11) {
			return false;
		}

		try {
			Long cpfNumber = Long.valueOf(cpf);
		} catch (NumberFormatException e) {
			System.out.println("CPF:" + cpf + " não é válido");
			return false;
		}

		return true;
	}
}
