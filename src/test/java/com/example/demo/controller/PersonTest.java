package com.example.demo.controller;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.example.demo.model.Person;
import com.example.demo.service.PersonSevice;

@WebMvcTest
public class PersonTest {

    @Autowired
    private PersonController personController;

    @MockBean
    private PersonSevice personSevice;
    
    @BeforeEach
    public void setup() {
        standaloneSetup(this.personController);
    }

    @Test
    public void shouldReturnSucess_postPerson() {
        when(this.personSevice.addPerson(new Person(UUID.randomUUID(), "James Bond")))
            .thenReturn(1);

        given()
            .accept(ContentType.JSON)
            .when()
                .post("/api/v1/person")
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldReturnSucess_getAllPeople() {
        given()
            .accept(ContentType.JSON)
            .when()
                .get("/api/v1/person")
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
