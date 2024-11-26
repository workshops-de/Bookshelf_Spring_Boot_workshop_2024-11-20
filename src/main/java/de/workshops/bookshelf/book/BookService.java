package de.workshops.bookshelf.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByIsbn(String isbn) {
        return this.bookRepository.findAll().stream().filter(book -> hasIsbn(book, isbn)).findFirst().orElseThrow();
    }

    private boolean hasIsbn(Book book, String isbn) {
        return book.getIsbn().equals(isbn);
    }

    public Book findBookByAuthor(String author) {
        return this.bookRepository.findAll().stream().filter(book -> hasAuthor(book, author)).findFirst().orElseThrow();

    }

    private boolean hasAuthor(Book book, String author) {
        return book.getAuthor().contains(author);
    }

    public List<Book> findBooksByAuthorOrIsbn(String author, String isbn) {
        return this.bookRepository.findAll().stream().filter(book -> hasAuthor(book, author) || hasIsbn(book,isbn)).toList();

    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
