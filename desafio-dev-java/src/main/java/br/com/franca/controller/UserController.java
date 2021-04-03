package br.com.franca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.dto.request.UserRequestDTO;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	@PostMapping
	public void save(@RequestBody UserRequestDTO dto) {		
		System.out.println(dto.toString());
	}
}
