package backend.hh.bookstore.webcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



public class BookController {

	// http://localhost:8080/mitävaan
	@RequestMapping("*")
	public String sayHello() {
		return "Hello World and ..... juuh !!";

	}
	// http://localhost:8080/hello?firstname=Tanja&lastname=Bergius
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greetingForm(Model model) {
       
        return "hello";
    }


}
