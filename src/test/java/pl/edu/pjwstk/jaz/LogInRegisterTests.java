package pl.edu.pjwstk.jaz;

import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@IntegrationTest
public class LogInRegisterTests {

    //szybkie tworzenie konta do sprawdzania testów
    @BeforeClass
    public static void beforeClass() throws Exception{
        given()
                .contentType(ContentType.JSON)
                .body(new RegisterRequest("Filipson", "Filipson123", "Filip"))
                .when()
                .post("/api/register")
                .thenReturn();
    }

    @Test
    public void should_respond_veri_good_to_login_request(){ //200
        var response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(new LoginRequest("Filipson", "Filipson123"))
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.cookies())
                .get("/api/user/article/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void should_respond_veri_bad_to_login_request(){ //401
        var response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(new LoginRequest("s18855", "wrongpassword"))
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.cookies())
                .get("/api/user/article/1")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value());
}

}
