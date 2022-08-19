package guru.springframework.spring5webapp.bootstrap;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.client.MultipartBodyBuilder.PublisherEntity;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository ar;
	private final BookRepository br;
	private final PublisherRepository pr;	
	
	public BootstrapData(AuthorRepository ar, BookRepository br, PublisherRepository pr) {
		super();
		this.ar = ar;
		this.br = br;
		this.pr = pr;
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		Publisher libritos= new Publisher("libritos", "calle falsa uno", "santiago", "chile");
		Author nino = new Author("nino", "el felino");
		Book libroa = new Book("el gato bello", "1234");
		
		nino.getBooks().add(libroa);
		libroa.getAuthors().add(nino);
		
		ar.save(nino);
		br.save(libroa);
		
		Author chibo = new Author("chibo", "lito");
		Book librob = new Book("me mori", "4567");
		
		chibo.getBooks().add(librob);
		librob.getAuthors().add(chibo);
		
		libritos.getBooks().add(librob);
		libritos.getBooks().add(libroa);
		
		ar.save(chibo);
		br.save(librob);
		pr.save(libritos);
		
			
		System.out.println("started on bootstrap");
		System.out.println("cantidad de autores: " + ar.count());
		System.out.println("cantidad de libros: " + br.count());
		System.out.println("cantidad de publicadores: "+ pr.count());
		
		
		
		
	}

}
