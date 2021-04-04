package br.com.franca.service.implementation;

import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;
import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.dto.out.UserResponseDTO;
import br.com.franca.service.exception.ResourceAlreadyExistsException;
import br.com.franca.service.exception.ResourceNotFoundException;
import br.com.franca.service.interfaces.UserService;

@Service
public class UserServiceIMP implements UserService {

	private UserRepository repository;

	public UserServiceIMP(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserResponseDTO findById(Long id) {
		
		UserResponseDTO userResponseDTO = repository.findById(id)
				.map(user -> new UserResponseDTO.UserResponseDTOBuilder()
						.id(user.getId())
						.name(user.getName())
						.genre(user.getGenre())
						.email(user.getEmail())
						.birthDate(user.getBirthDate())
						.naturalness(user.getNaturalness())
						.nationality(user.getNationality())
						.cpf(user.getCpf())
						.buildUserResponseDTO())
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
		
		return userResponseDTO;
	}

	@Override
	public Long save(UserDTO dto) {
		
		if (!isCpf(dto.getCpf())) {
			throw new IllegalArgumentException("CPF deve conter 11 dígitos entre [0 e 9]");
		}	

		if (repository.findByCpf(dto.getCpf()).isPresent()) {
			throw new ResourceAlreadyExistsException("Já existe um Usuário com o cpf informado");
		}
 
		User user = dto.toUser();

		return repository.save(user).getId();
	}

	private boolean isCpf(String cpf) {

		if (cpf.contains("-") || cpf.contains(".")) {
			return false;
		}

		if (cpf.length() != 11) {
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
