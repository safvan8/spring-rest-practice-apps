package in.ineuron.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Book;

@RestController
@RequestMapping("/api/book/")
public class BookController {
	
	@GetMapping(value = "/getBook/{isbn}", produces = "application/json")
    public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) {
        Book book = new Book(isbn, "Spring", 234.5, "RodJhonson");

        // Create a link to the getAllBooks method of the BookController class
		Link link = WebMvcLinkBuilder
						.linkTo(
						// Use the methodOn() method to resolve a method reference to the getAllBooks method
						WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()
						)
						.withRel("allBooks"); // Set the relationship (rel) of the link as "allBooks"

        book.add(link);

        return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allBooks")
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("ISBN-111", "Spring", 350.5, "RodJhonson"));
        bookList.add(new Book("ISBN-222", "Hibernate", 350.5, "GavinKing"));
        bookList.add(new Book("ISBN-333", "Servlet", 350.5, "KeitySeirra"));

        return bookList;
    }
}

// if code not working, run on external tomact
