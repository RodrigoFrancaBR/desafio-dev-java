package br.com.franca.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.interfaces.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid UserDTO dto) {		
		Long id = service.save(dto);
		URI uri = obterUri(id);
		return ResponseEntity.created(uri).build();
	}

	private URI obterUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
