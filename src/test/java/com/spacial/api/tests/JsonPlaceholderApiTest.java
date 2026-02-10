package com.spacial.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderApiTest {

    @BeforeClass
    public void setup() {
        // Allows override in CI: -Dapi.baseUrl=https://jsonplaceholder.typicode.com
        RestAssured.baseURI = System.getProperty("api.baseUrl", "https://jsonplaceholder.typicode.com");
    }

    @Test(description = "Positive: GET /posts/1 should return 200 and expected fields")
    public void getPost_positive() {
        RestAssured
                .given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("userId", greaterThan(0))
                .body("title", not(blankString()));
    }

    @Test(description = "Negative: GET /posts/0 should return 404 (non-existing post)")
    public void getPost_negative_notFound() {
        RestAssured
                .given()
                .when()
                .get("/posts/0")
                .then()
                .statusCode(404);
    }

    @Test(description = "Contract-like: GET /posts/1 matches expected schema")
    public void getPost_contractValidation() {
        RestAssured
                .given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("schemas/jsonplaceholder_post_schema.json"));
    }

    // Optional extra (if you want POST instead of schema on GET)
    // JSONPlaceholder accepts POST and returns a 201 with id=101 typically.
    @Test(enabled = false, description = "Optional: POST /posts should return 201 and echo request fields")
    public void createPost_optional() {
        Map<String, Object> payload = Map.of(
                "userId", 1,
                "title", "spacial test",
                "body", "hello");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("userId", equalTo(1))
                .body("title", equalTo("spacial test"))
                .body("body", equalTo("hello"))
                .body("id", greaterThan(0));
    }
}
