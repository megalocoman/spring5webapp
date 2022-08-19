package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;

@Controller
public class BookController {
	
	private final BookRepository br ;
	private final AuthorRepository ar ;
	
	public BookController(BookRepository br, AuthorRepository ar) {
		this.br = br;
		this.ar = ar;
	}

	@RequestMapping("/books")
	public String getBook(Model model) {
		
		model.addAttribute("books", br.findAll());
		
		return "list";
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", ar.findAll());
		
		return "listAuthor";
	}

}
