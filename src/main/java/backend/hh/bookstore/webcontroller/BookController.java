package backend.hh.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import backend.hh.bookstore.domain.Book;
import backend.hh.bookstore.domain.BookRepository;
import backend.hh.bookstore.domain.CategoryRepository;


@Controller
public class BookController {

	@Autowired
	private BookRepository repo;
	@Autowired
	private CategoryRepository repo2;
	
	@GetMapping("/index")
	public String indexGet(Model model) {
		return "index";
	}

	@GetMapping("/booklist")
	public String booklistGet(Model model) {
		model.addAttribute("books", repo.findAll());
		return "booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String bookDelete(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);
		return "redirect:../booklist";
	}
	
	@GetMapping("/addbook")
	public String addbookGet(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", repo2.findAll());
		return "addbook";
	}
	
	@PostMapping("/savebook")
	public String savebookPost(Book book) {
		repo.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/editbook/{id}")
	public String editbookGet(@PathVariable("id") Long id, Model model) {
		Book book = repo.findById(id).get();
		model.addAttribute("book", book);
		model.addAttribute("categories", repo2.findAll());
		return "editbook";
	}
}

