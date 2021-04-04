package br.com.franca.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;
import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.dto.out.UserResponseDTO;
import br.com.franca.service.exception.ResourceAlreadyExistsException;
import br.com.franca.service.exception.ResourceNotFoundException;
import br.com.franca.service.interfaces.UserService;
import br.com.franca.service.util.CpfUtil;

@Service
public class UserServiceIMP implements UserService {

	private UserRepository repository;

	public UserServiceIMP(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserResponseDTO findById(Long id) {
		
		return repository.findById(id)
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
	}

	@Override
	public Long save(UserDTO dto) {
		
		validateCpf(dto.getCpf());		
		
		repository.findByCpf(dto.getCpf()).ifPresent(user -> {
			throw new ResourceAlreadyExistsException("Já existe um Usuário com o cpf informado");
		});				
		
		User user = dto.toUser();

		return repository.save(user).getId();
	}
	
	@Override
	public void update(Long id, UserDTO dto) {
		
		validateCpf(dto.getCpf());
		
		Optional<User> userFindOptional = repository.findByCpf(dto.getCpf());
		
		if(userFindOptional.isPresent() && !id.equals(userFindOptional.get().getId())) {
			throw new ResourceAlreadyExistsException("Já existe um Usuário com o cpf informado");
		}		

		User userFind = repository.findById(id)
		.map(u->{
			User user = dto.toUser();
			user.setId(u.getId());
			return user;
		}).orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado"));
		
		repository.save(userFind);
		
	}

	@Override
	public void delete(Long id) {	
		
		Optional<User> optional = repository.findById(id);
		
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("Usuário não encontrado");
		}
		
		repository.delete(optional.get());
		
	}
	
	private void validateCpf(String cpf) {
		if (!CpfUtil.isValid(cpf)) {
			throw new IllegalArgumentException("CPF deve conter 11 dígitos entre [0 e 9]");
		}		
	}	

}
