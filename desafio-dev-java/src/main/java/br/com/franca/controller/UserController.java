package br.com.franca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.dto.request.UserRequestDTO;
import br.com.franca.service.interfaces.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	
	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping
	public void save(@RequestBody UserRequestDTO dto) {		
		Long id = service.save(dto);
		System.out.println(id);
	}
}