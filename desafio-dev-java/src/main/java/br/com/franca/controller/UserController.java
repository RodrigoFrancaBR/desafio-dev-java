package br.com.franca.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.franca.service.dto.in.UserFrontDTO;
import br.com.franca.service.dto.out.UserViewDTO;
import br.com.franca.service.interfaces.UserService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<UserViewDTO>> findAll() {
		List<UserViewDTO> listDTO = service.findAll();
		return ResponseEntity.ok(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserViewDTO> findBy(@PathVariable Long id) {
		UserViewDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid UserFrontDTO dto) {		
		Long id = service.save(dto);
		URI uri = obterUri(id);
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")	
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UserFrontDTO dto) {
		service.update(id, dto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	private URI obterUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
