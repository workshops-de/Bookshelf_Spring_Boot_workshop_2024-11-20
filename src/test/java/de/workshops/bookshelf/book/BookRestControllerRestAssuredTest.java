package de.workshops.bookshelf.book;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookRestControllerRestAssuredTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private BookRestController bookRestController;

    @Test
    @WithMockUser
    public void testWithRestAssuredMockMvc() {
//        RestAssuredMockMvc.standaloneSetup(bookRestController);
        RestAssuredMockMvc.mockMvc(mockMvc);
        RestAssuredMockMvc.given().
                    log().all().
                when().
                    get("/book").
                then().
                    log().all().
                    statusCode(200).
                    body("author[0]", equalTo("Erich Gamma"));
    }


}