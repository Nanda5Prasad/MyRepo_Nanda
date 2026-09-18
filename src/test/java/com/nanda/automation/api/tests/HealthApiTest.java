package com.nanda.automation.api.tests;

import com.nanda.automation.api.base.BaseApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HealthApiTest extends BaseApiTest {
    @Test(groups = {"api", "smoke"})
    public void getRequestShouldReturnSuccessfulResponse() {
        given()
                .spec(request)
        .when()
                .get("/status/200")
        .then()
                .statusCode(200);
    }

    @Test(groups = "api")
    public void getRequestShouldReturnExpectedJsonValue() {
        given()
                .spec(request)
        .when()
                .get("/json")
        .then()
                .statusCode(200)
                .body("slideshow.author", equalTo("Yours Truly"));
    }
}
