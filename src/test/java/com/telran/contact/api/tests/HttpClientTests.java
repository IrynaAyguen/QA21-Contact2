package com.telran.contact.api.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.telran.contact.api.dto.AuthErrorDto;
import com.telran.contact.api.dto.AuthRequestDto;
import com.telran.contact.api.dto.AuthResponseDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpClientTests {
    @Test
    public void loginHttpClientTest() throws IOException {
        String email = "ira@web.de";
        String password = "Ira123123_";

        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login").bodyString("{\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"" + password + "\"\n" +
                        "}", ContentType.APPLICATION_JSON)
                .execute();

        //   System.out.println(response);
        String responseJson = response.returnContent().asString();

        System.out.println(responseJson);

        JsonElement element = JsonParser.parseString(responseJson);
        JsonElement token = element.getAsJsonObject().get("token");

        System.out.println(token.getAsString());

    }

    @Test
    public void loginHttpClientTestWithDto() throws IOException {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("ira@web.de")
                .password("Ira123123_")
                .build();

        Gson gson = new Gson();

        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
                .execute();

        String responseJson = response.returnContent().asString();
        AuthResponseDto responseDto = gson.fromJson(responseJson, AuthResponseDto.class);

        System.out.println(responseDto.getToken());

    }

    @Test
    public void loginHttpClientNegativTestWithDto() throws IOException {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("ira@web.")  //invalid
                .password("Ira123123_")
                .build();

        Gson gson = new Gson();

        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
                .execute();

        HttpResponse httpResponse = response.returnResponse();
        System.out.println(httpResponse);  //witout parsing

        System.out.println(httpResponse.getStatusLine().getStatusCode());  //print => statuscode=400
        InputStream inputStream = httpResponse.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        StringBuilder sb = new StringBuilder();

        while ((line=reader.readLine())!= null) {
            sb.append(line);
        }
        AuthErrorDto error = gson.fromJson(sb.toString(),AuthErrorDto.class);
        System.out.println(error.getCode());
        System.out.println(error.getMessage());
        System.out.println(error.getDetails());
    }

}
