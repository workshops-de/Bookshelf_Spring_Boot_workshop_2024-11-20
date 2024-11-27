package de.workshops.bookshelf.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.workshops.bookshelf.ObjectMapperTestConfiguration;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(ObjectMapperTestConfiguration.class)
@WithMockUser(roles = "ADMIN")
//@WithMockUser()
class BookRestControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.[1].title", Matchers.is("Clean Code")));
    }


    @Test
    void getAllBookMockResult() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                .andReturn();


        String jsonPayload = mvcResult.getResponse().getContentAsString();
        System.out.println(jsonPayload);
        Book[] books = objectMapper.readValue(jsonPayload, Book[].class);

        assertThat(books).hasSize(3);
        assertThat(books[1].getTitle()).isEqualTo("Clean Code");

    }


    @Test
    void createBook() throws Exception {

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .content("""
                                {
                                    "isbn": "%s",
                                    "title": "%s",
                                    "author": "%s",
                                    "description": "%s"
                                }""".formatted("xxx-xxx-xxx-", "Fancy Book", "Fancy author", "Fancy description"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

}