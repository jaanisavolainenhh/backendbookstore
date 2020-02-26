package backend.hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.hh.bookstore.domain.Book;
import backend.hh.bookstore.domain.BookRepository;



@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repo) {
		return (args) -> {
		
			log.info("Toimii ennen addaamista.");
			repo.save(new Book("Kirja 1", "A A", 1900, "123", 9.99));
			repo.save(new Book("Kirja 2 ", "B B", 2000, "456", 19.99));
			repo.save(new Book("Kirja 3", "C C", 2100, "789", 29.99));

			for (Book book : repo.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
