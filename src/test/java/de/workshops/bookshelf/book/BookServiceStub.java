package de.workshops.bookshelf.book;

import java.util.List;

public class BookServiceStub extends BookService {
    public BookServiceStub() {
        super (null);
    }

    @Override
    public List<Book> allBooks() {
        return List.of(new Book(), new Book(), new Book());
    }
}
