package de.workshops.bookshelf.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BookRestControllerMockitoExtensionTest {

    @Mock
    private BookService bookServiceMock;

    @InjectMocks
    private BookRestController bookRestController;

    @Test
    void getAllBook() {
        Mockito.when(bookServiceMock.allBooks()).thenReturn(List.of(new Book(), new Book(), new Book()));

        final List<Book> books = bookRestController.getAllBooks();

        assertThat(books).hasSize(3);
    }

}