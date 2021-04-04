package br.com.franca.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;
import br.com.franca.service.dto.in.UserFrontDTO;
import br.com.franca.service.dto.in.UserFrontMapper;
import br.com.franca.service.dto.out.UserViewDTO;
import br.com.franca.service.dto.out.UserViewMapper;
import br.com.franca.service.exception.ResourceAlreadyExistsException;
import br.com.franca.service.exception.ResourceNotFoundException;
import br.com.franca.service.interfaces.UserService;
import br.com.franca.service.util.CpfUtil;

@Service
public class UserServiceIMP implements UserService {

	private UserRepository repository;
	private final UserFrontMapper frontMapper;
	private final UserViewMapper viewMapper;

	public UserServiceIMP(UserRepository repository) {
		this.repository = repository;
		this.frontMapper = new UserFrontMapper();
		this.viewMapper = new UserViewMapper();
	}
	
	@Override
	public List<UserViewDTO> findAll() {
		return repository.findAll().stream().map(viewMapper::map).collect(Collectors.toList());
	}

	@Override
	public UserViewDTO findById(Long id) {
		
		return repository.findById(id).map(viewMapper::map)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
	}

	@Override
	public Long save(UserFrontDTO dto) {
		
		validateCpf(dto.getCpf());		
		
		repository.findByCpf(dto.getCpf()).ifPresent(user -> {
			throw new ResourceAlreadyExistsException("Já existe um Usuário com o cpf informado");
		});				
		
		User user = frontMapper.map(dto);	

		return repository.save(user).getId();
	}
	
	@Override
	public void update(Long id, UserFrontDTO dto) {
		
		validateCpf(dto.getCpf());
		
		Optional<User> userFindOptional = repository.findByCpf(dto.getCpf());
		
		if(userFindOptional.isPresent() && !id.equals(userFindOptional.get().getId())) {
			throw new ResourceAlreadyExistsException("Já existe um Usuário com o cpf informado");
		}		

		User userFind = repository.findById(id)
		.map(u->{
			User user = frontMapper.map(dto);
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
