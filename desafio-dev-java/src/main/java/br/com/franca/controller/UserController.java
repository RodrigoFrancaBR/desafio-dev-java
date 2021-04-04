package br.com.franca.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.franca.service.dto.UserDTO;
import br.com.franca.service.dto.out.UserResponseDTO;
import br.com.franca.service.interfaces.UserService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> findBy(@PathVariable Long id) {
		UserResponseDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}


	@PostMapping
	public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserDTO dto) {		
		Long id = service.save(dto);
		URI uri = obterUri(id);
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")	
	public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody @Valid UserDTO dto) {
		service.update(id, dto);
		return ResponseEntity.noContent().build();
	}	
	

	private URI obterUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
