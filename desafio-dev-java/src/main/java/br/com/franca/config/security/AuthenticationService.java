package br.com.franca.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.franca.domain.User;
import br.com.franca.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	private UserRepository userRepository;

	public AuthenticationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = this.userRepository.findByUserName(username);

		if (user.isPresent()) {
			return user.get();
		}

		throw new UsernameNotFoundException("Usuário não encontrado");
	}

}
