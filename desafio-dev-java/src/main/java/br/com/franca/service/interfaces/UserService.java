package br.com.franca.service.interfaces;

import java.util.List;

import br.com.franca.service.dto.in.UserFrontDTO;
import br.com.franca.service.dto.out.UserViewDTO;

public interface UserService {

	public Long save(UserFrontDTO dto);

	public UserViewDTO findById(Long id);

	public void update(Long id, UserFrontDTO dto);

	public void delete(Long id);

	public List<UserViewDTO> findAll();
	
}
