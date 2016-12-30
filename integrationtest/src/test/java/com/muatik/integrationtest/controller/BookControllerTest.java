package com.muatik.integrationtest.controller;


import com.muatik.integrationtest.model.Book;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by mustafaatik on 30/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookControllerTest {
    private String ENDPOINT = "/api/v1/books/";

    private class BookBuilder {
        private Book book = new Book();

        public BookBuilder title(long id) {
            book.setId(id);
            return this;
        }

        public BookBuilder title(String title) {
            book.setTitle(title);
            return this;
        }
    }

    List<Book> books = new ArrayList<Book>(){{
        add(new Book("Book 1"));
        add(new Book("Book 2"));
        add(new Book("Book 3"));
    }};

    @Before
    public void setUp() {
        books.forEach(book -> {
            given()
                    .contentType(ContentType.JSON)
                    .body(book, ObjectMapperType.JACKSON_2)
                    .when()
                    .post(ENDPOINT)
                    .then()
                    .statusCode(HttpStatus.CREATED.value());
        });
    }

    @Test
    public void get() {
        when()
                .get(ENDPOINT).
                then().
                contentType(ContentType.JSON).
                body("size()", equalTo(books.size()));
    }


}
