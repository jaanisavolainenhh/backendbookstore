package backend.hh.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import backend.hh.bookstore.webcontroller.BookController;
import backend.hh.bookstore.webcontroller.CategoryController;
import backend.hh.bookstore.webcontroller.UserController;



@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
class BookstoreApplicationTests {

	@Autowired
	private BookController BController;
	
	@Autowired
	private CategoryController CController;
	
	@Autowired
	private UserController UController;
	
	@Test
	void contextLoads()  throws Exception{
		assertThat(BController).isNotNull();
	}
	@Test
	void contextLoads2()  throws Exception{
		assertThat(CController).isNotNull();
	}
	@Test
	void contextLoads3()  throws Exception{
		assertThat(UController).isNotNull();
	}

}
