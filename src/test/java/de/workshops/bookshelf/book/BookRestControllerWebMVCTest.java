package de.workshops.bookshelf.book;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@WebMvcTest(BookRestController.class)
class BookRestControllerWebMVCTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWebMockMvc() {
        RestAssuredMockMvc.mockMvc(mockMvc);
        Book book = new Book();
        RestAssuredMockMvc.
                given().
                log().all().
                contentType("application/json").
                body(book).
                    post("/book");
        verify(bookService).createBook(any());
    }


}