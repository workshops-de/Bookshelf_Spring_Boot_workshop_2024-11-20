package de.workshops.bookshelf.book;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookRestControllerMockBeanTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private BookRestController bookRestController;

    @Test
    void getAllBook() {
        Mockito.when(bookService.allBooks()).thenReturn(List.of(new Book(), new Book()));

        final List<Book> books = bookRestController.getAllBooks();

        assertThat(books).hasSize(2);
    }

}