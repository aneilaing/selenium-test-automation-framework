package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void getPostsShouldReturnSuccessfulResponse() {
        Response response = RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }

    @Test
    public void createPostShouldReturnCreatedResponse() {
        String requestBody = """
            {
              "title": "SDET Portfolio Test",
              "body": "API automation using REST Assured",
              "userId": 1
            }
            """;

        Response response = RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("title"), "SDET Portfolio Test");
    }
}
