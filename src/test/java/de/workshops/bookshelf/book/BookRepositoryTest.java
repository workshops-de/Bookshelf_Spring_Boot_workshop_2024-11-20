package de.workshops.bookshelf.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepositoryUnderTest;

    @Test
    void selectAllBooks() {
        List<Book> allBooks = bookRepositoryUnderTest.findAll();

        assertThat(allBooks).hasSize(3);
    }

    @Test
    void findBookByTitle() {
        var book = bookRepositoryUnderTest.findByTitle("Clean Code");

        assertThat(book.getTitle()).isEqualTo("Clean Code");
    }

}
