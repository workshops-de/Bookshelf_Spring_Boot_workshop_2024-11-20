package de.workshops.bookshelf.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookRestControllerTest {

    @Autowired
    private BookRestController bookRestController;

    @Test
    void getAllBook() {
        final List<Book> books = bookRestController.getAllBooks();

        assertThat(books).hasSize(3);
    }

}