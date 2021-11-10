package com.telran.contact.api.tests;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.telran.contact.api.dto.*;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


public class RestAssuredTests {

    @BeforeMethod
    public void ensurePreconditions() {
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginRestAssuredTest() {

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("ira@web.de")
                .password("Ira123123_")
                .build();

        AuthResponseDto responseDto = RestAssured.given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println(responseDto.getToken());

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImlyYUB3ZWIuZGUifQ.ncWvCxA8tqNwZ8DhwlJJJAGdLVRQIXSxRKMjd9cvr28";

        String responseToken = RestAssured.given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .body("token", equalTo(token))
                .extract().path("token");

        System.out.println(responseToken);
    }

    @Test  //HOME WORK 1
    public void addNewContactRestAssuredTest() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IjExMTExQHdlYi5kZSJ9.XMxzoF3pIQTNEcl-jRTsPo8cYvJeTf3FE4p3k8IiF5U";

        AddNewContactRequestDto contactDto = AddNewContactRequestDto.builder()
                .address("Moscow 5678")
                .description("sister5678")
                .email("sveta5678@web.de")
                .id(0)
                .lastName("Svetlanova")
                .name("Svetlana")
                .phone("+4910035678")
                .build();

        int id = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(contactDto)
                .post("contact")
                .then().assertThat()
                .statusCode(200)
                .extract().path("id");

        System.out.println("id: " + id);
    }


    @Test //HOME WORK 2
    public void updateContactRestAssuredTest() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IjExMTExQHdlYi5kZSJ9.XMxzoF3pIQTNEcl-jRTsPo8cYvJeTf3FE4p3k8IiF5U";

        AddNewContactRequestDto contactDto = AddNewContactRequestDto.builder()
                .address("Moscow 999")
                .description("sister999")
                .email("sveta999@web.de")
                .id(18154)
                .lastName("Svetlanova")
                .name("Svetlana")
                .phone("+4999999999")
                .build();
        UpdateContactResponseDto responseDto = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(contactDto)
                .put("contact")
                .then().assertThat()
                .statusCode(200)
                .extract().response().as(UpdateContactResponseDto.class);

        System.out.println("id:" + responseDto.getId() + " lastName:" + responseDto.getLastName()
                + " email:" + responseDto.getEmail() + " phone:" + responseDto.getPhone());

    }

    @Test //HOME WORK 3
    public void addNewContactNegativeRestAssuredTest() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IjExMTExQHdlYi5kZSJ9.XMxzoF3pIQTNEcl-jRTsPo8cYvJeTf3FE4p3k8IiF5U";

        AddNewContactRequestDto contactDto = AddNewContactRequestDto.builder()
                .address("")   // invalid format - withiut adresse
                .description("sister5678")
                .email("svetlana@web.")
                .id(0)
                .lastName("Svetlanova")
                .name("Svetlana")
                .phone("+4555")
                .build();

        String errorMessage = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(contactDto)
                .post("contact")
                .then().assertThat()
                .statusCode(400)
                .extract().path("message");

         System.out.println(errorMessage);

    }
}
