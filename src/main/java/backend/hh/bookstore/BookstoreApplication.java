package backend.hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.hh.bookstore.domain.Book;
import backend.hh.bookstore.domain.BookRepository;
import backend.hh.bookstore.domain.Category;
import backend.hh.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean // tähän voi tunkea loputtomasti argumentteja näköjään?
	public CommandLineRunner bookstoreDemo(BookRepository repo, CategoryRepository repo2) {
		return (args) -> {

			repo2.save(new Category("Erotiikka"));
			repo2.save(new Category("Politiikka"));
			repo2.save(new Category("Eroottinen politiikka"));
			log.info("Toimii ennen addaamista.");
			repo.save(new Book("Kirja 1", "A A", 1900, "123", 9.99, repo2.findByName("Erotiikka").get(0)));
			repo.save(new Book("Kirja 2 ", "B B", 2000, "456", 19.99,repo2.findByName("Politiikka").get(0)));
			repo.save(new Book("Kirja 3", "C C", 2100, "789", 29.99, repo2.findByName("Eroottinen politiikka").get(0)));


			for (Book book : repo.findAll()) {
				log.info(book.toString());
			}

			for (Category category : repo2.findAll()) {
				log.info(category.toString());
			}

		};
	}

//		@Bean
//		public CommandLineRunner lisataanpaKategorioita(CategoryRepository repo) {
//			return (args) -> {
//
//				repo.save(new Category("Erotiikka"));
//				repo.save(new Category("Politiikka"));
//				
////				for (Book book : repo.findAll()) {
////					log.info(book.toString());
////				}
//
//			};
//	}
}
