package org.acme.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class UserResourceTest {

  @Test
  public void testList() {
    given()
        .when().get("/users")
        .then()
        .statusCode(200)
        .body("$.size()", is(0));
  }

  @Test
  public void testAdd() {
    final String name = "smol";
    final String email = "smol@gmail.com";

    given()
        .body("{\"name\": \"%s\", \"email\": \"%s\"}".formatted(name, email))
        .header("Content-Type", ContentType.JSON)
        .when()
        .post("/users")
        .then()
        .statusCode(200)
        .body("$.size()", is(1),
            "name", containsInAnyOrder(name),
            "email", containsInAnyOrder(email));

    given()
        .body("{\"name\": \"%s\"}".formatted(name))
        .header("Content-Type", ContentType.JSON)
        .when()
        .delete("/users")
        .then()
        .statusCode(200)
        .body("$.size()", is(0));
  }
}