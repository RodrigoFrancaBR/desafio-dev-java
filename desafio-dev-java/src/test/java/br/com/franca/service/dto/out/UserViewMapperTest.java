package br.com.franca.service.dto.out;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.franca.domain.Genre;
import br.com.franca.domain.User;

class UserViewMapperTest {	

	private static User user;
	private static UserViewMapper viewMapper;
	
	@BeforeAll
	public static void beforeAll() {
		
		 user = new User.UserBuilder("Rodrigo", LocalDate.now(), "12345665432")
				 	.id(10l)
				 	.genre(Genre.MASCULINO)
					.email("rodrigo@email.com")
					.naturalness("Rio de Janeiro")
					.nationality("Brasileiro")
					.buildUser();
		
		viewMapper = new UserViewMapper();
	}
	

	@Test
	void shouldConvertUserToUserViewDTO() {		

		UserViewDTO dto = viewMapper.map(user);
		assertEquals(user.getId(), dto.getId());
		assertEquals(user.getName(), dto.getName());
		assertEquals(user.getBirthDate(), dto.getBirthDate());
		assertEquals(user.getCpf(), dto.getCpf());
		assertEquals(user.getGenre(), dto.getGenre());
		assertEquals(user.getEmail(), dto.getEmail());
		assertEquals(user.getNaturalness(), dto.getNaturalness());
		assertEquals(user.getNationality(), user.getNationality());
	}

}
