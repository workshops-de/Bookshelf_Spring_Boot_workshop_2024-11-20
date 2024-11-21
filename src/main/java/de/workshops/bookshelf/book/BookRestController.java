package de.workshops.bookshelf.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Use Spring annotations to make this class a RestController mapped to an HTTP URL.
@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.allBooks();
    }

    @GetMapping("{isbn}")
    public Book getBookByIsdn(@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @GetMapping(params="author")
    public Book getBookByAuthor(@RequestParam("author") String author) {
        return this.bookService.findBookByAuthor(author);
    }

    @PostMapping("/search")
    public List<Book> searchBooks(@RequestBody BookSearchRequest request) {
        return bookService.findBooksByAuthorOrIsbn(request.getAuthor(), request.getIsbn() );

    }

    @GetMapping("/error")
    public Object error() throws BookException {
        throw  new BookException();
    }

    @ExceptionHandler(BookException.class)
    public ResponseEntity error (BookException e) {
        return new ResponseEntity("Ich bin ein Fehler", HttpStatus.I_AM_A_TEAPOT);
    }

    // Map a method returning books to HTTP GET requests for this controller's URL.
    // ...
}