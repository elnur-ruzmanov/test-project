import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {
    @Test
    void simpleTest(){
        String body= """
                {
                    "id": 0,
                    "username": "string",
                    "firstName": "string",
                    "lastName": "string",
                    "email": "string",
                    "password": "string",
                    "phone": "string",
                    "userStatus": 0
                  }""";
       Response respose = given()
                    .header("accept", "application/json")
                     .header("Content-Type", "application/json")
                    .baseUri("https://petstore.swagger.io/v2/")
                .when()
                    .body(body)
                    .post("user")
                .andReturn();
       int actualCode = respose.getStatusCode();
        Assertions.assertEquals(201, actualCode);
    }
}
