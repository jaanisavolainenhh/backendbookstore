package backend.hh.bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import backend.hh.bookstore.domain.Category;
import backend.hh.bookstore.domain.CategoryRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureMockMvc
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository repository;



	
	@Test
	public void search() throws Exception {
		List<Category> categories = repository.findByName("Erotiikka");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Erotiikka");
	}

	@Test
	public void create() throws Exception {
		Category category = new Category();
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}


	@Test
	public void delete() throws Exception {
		List<Category> categories = repository.findByName("Erotiikka");
		assertThat(categories).hasSize(1);
		Category category = categories.get(0);
		repository.delete(category);
		categories = repository.findByName("Erotiikka");
		assertThat(categories).isEmpty();	
	}
}