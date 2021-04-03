package br.com.franca.service.interfaces;

import br.com.franca.dto.request.UserRequestDTO;

public interface UserService {
	
	public Long save(UserRequestDTO dto);

}
