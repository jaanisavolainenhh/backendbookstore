package backend.hh.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import backend.hh.bookstore.domain.Book;
import backend.hh.bookstore.domain.Category;
import backend.hh.bookstore.domain.User;
import backend.hh.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureMockMvc
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;



	
	@Test
	public void search() throws Exception {
		User books = repository.findByUsername("user");
		assertThat(books.getId()).isNotNull();
	}

	@Test
	public void create() throws Exception {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "email@email.com");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}


	@Test
	public void delete() throws Exception {
		User user = repository.findByUsername("user");
		assertThat(user.getId()).isNotNull();
		repository.delete(user);
		user = repository.findByUsername("user");
		assertThat(user).isNull();
		
	}
}