package de.workshops.bookshelf.book;

import lombok.Data;

@Data
public class BookSearchRequest {

    private String author;
    private String isbn;
}