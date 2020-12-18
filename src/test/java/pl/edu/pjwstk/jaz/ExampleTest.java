package pl.edu.pjwstk.jaz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@IntegrationTest
public class ExampleTest {
    @Test
    public void should_respond_to_readiness_request() {
        given()
                .when()
                .get("/api/is-ready")
                .then()
                .statusCode(200);


    }
}