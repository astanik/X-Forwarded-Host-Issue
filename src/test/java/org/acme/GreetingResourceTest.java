package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testXForwardedHostHeader() {
        given()
          .when()
              .header("X-Forwarded-Host", "localhost:5173")
          .get("/test")
          .then()
             .statusCode(200)
             .body(is("localhost:5173"));
    }

}