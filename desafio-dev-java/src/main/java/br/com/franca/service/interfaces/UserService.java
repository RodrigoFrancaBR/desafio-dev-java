package br.com.franca.service.interfaces;

import java.util.List;

import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.dto.out.UserResponseDTO;

public interface UserService {

	public Long save(UserDTO dto);

	public UserResponseDTO findById(Long id);

	public void update(Long id, UserDTO dto);

	public void delete(Long id);

	public List<UserResponseDTO> findAll();
	
}
