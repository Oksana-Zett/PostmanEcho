package ru.netology.rest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Postman {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("{\n" +
                        "\"birthday\": \"13.06.1999\",\n" +
                        "\"name\": \"Иван\",\n" +
                        "\"passport\": \"4444 № 44444444\",\n" +
                        "\"patronymic\": \"Иванович\",\n" +
                        "\"phone\": \"+7 (999)-999-99-99\",\n" +
                        "\"surname\": \"Иванов\"\n" +
                        "}") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("{\n" +
                        "\"birthday\": \"13.06.1999\",\n" +
                        "\"name\": \"Иван\",\n" +
                        "\"passport\": \"4444 № 44444444\",\n" +
                        "\"patronymic\": \"Иванович\",\n" +
                        "\"phone\": \"+7 (999)-999-99-99\",\n" +
                        "\"surname\": \"Иванов\"\n" +
                        "}"))
        ;
    }
}
