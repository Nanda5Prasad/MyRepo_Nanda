package com.nanda.automation.api.base;

import com.nanda.automation.config.Config;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {
    protected RequestSpecification request;

    @BeforeClass
    public void setUpApi() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        request = RestAssured.given()
                .baseUri(Config.apiBaseUrl())
                .contentType("application/json")
                .accept("application/json");
    }
}
