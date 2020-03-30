package backend.hh.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import backend.hh.bookstore.domain.Book;
import backend.hh.bookstore.domain.BookRepository;
import backend.hh.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureMockMvc
public class BookRepositoryTests {

	@Autowired
	private BookRepository repository;



	
	@Test
	public void searchBook() throws Exception {
		List<Book> books = repository.findByTitle("Kirja 1");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Kirja 1");
	}

	@Test
	public void createNewBook() throws Exception {
		Book book = new Book("Title", "Author", 1987, "ISBN", 99.9, new Category());
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}


	@Test
	public void deleteBook() throws Exception {
		List<Book> books = repository.findByTitle("Kirja 1");
		assertThat(books).hasSize(1);
		Book book = books.get(0);
		repository.delete(book);
		books = repository.findByTitle("Kirja 1");
		assertThat(books).isEmpty();	
	}
}