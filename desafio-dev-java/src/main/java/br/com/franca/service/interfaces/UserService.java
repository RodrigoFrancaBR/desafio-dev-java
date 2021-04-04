package br.com.franca.service.interfaces;

import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.dto.out.UserResponseDTO;

public interface UserService {

	public Long save(UserDTO dto);

	public UserResponseDTO findById(Long id);

	public void update(Long id, UserDTO dto);
	
}
