package br.com.franca.service.dto.in;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.franca.domain.Genre;
import br.com.franca.domain.User;

class UserFrontMapperTest {
	
	private static UserFrontDTO userFrontDTO;
	private static UserFrontMapper frontMapper;
	
	@BeforeAll
	public static void beforeAll() {
		
		 userFrontDTO = new UserFrontDTO.UserFrontDTOBuilder()
				 	.name("Fabiano")
				 	.birthDate(LocalDate.now())
				 	.cpf("12365498712")
				 	.genre(Genre.MASCULINO)
					.email("rodrigo@email.com")
					.naturalness("Rio de Janeiro")
					.nationality("Brasileiro")
					.buildUserFrontDTO();
		
		frontMapper = new UserFrontMapper();		
	}

	@Test
	void shouldConvertUserFrontDTOToUser() {

		User user = frontMapper.map(userFrontDTO);

		assertEquals(userFrontDTO.getName(), user.getName());
		assertEquals(userFrontDTO.getBirthDate(), user.getBirthDate());
		assertEquals(userFrontDTO.getCpf(), user.getCpf());
		assertEquals(userFrontDTO.getGenre(), user.getGenre());
		assertEquals(userFrontDTO.getEmail(), user.getEmail());
		assertEquals(userFrontDTO.getNaturalness(), user.getNaturalness());
		assertEquals(userFrontDTO.getNationality(), user.getNationality());
	}
	
}
