package br.com.franca.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.config.security.TokenService;
import br.com.franca.domain.LoginDTO;
import br.com.franca.domain.TokenDTO;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

	private AuthenticationManager authenticationManager;	
	private TokenService tokenService;

	public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
		
	}

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginDTO dto) {

		UsernamePasswordAuthenticationToken authenticationToken = dto.getAuthenticationToken();

		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		
		String token = tokenService.generateToken(authentication);	
		
		return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
	
	}
}
