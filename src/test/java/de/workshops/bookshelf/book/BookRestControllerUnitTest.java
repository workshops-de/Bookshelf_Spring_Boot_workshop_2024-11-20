package de.workshops.bookshelf.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookRestControllerUnitTest {

    private BookRestController bookRestController;

    @Test
    void getAllBook() {
        bookRestController = new BookRestController(new BookServiceStub());
        final List<Book> books = bookRestController.getAllBooks();

        assertThat(books).hasSize(3);
    }

}