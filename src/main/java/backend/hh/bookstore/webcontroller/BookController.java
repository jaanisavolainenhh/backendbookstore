package backend.hh.bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@GetMapping("/index")
	public String indexGet(Model model) {
		return "index";
	}

}

//Tästä nyt vaan testiä
