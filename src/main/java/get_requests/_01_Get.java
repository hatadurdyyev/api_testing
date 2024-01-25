package get_requests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class _01_Get {
    String url = "https://restful-booker.herokuapp.com/booking/0";

    @Test
    public void get01() {
        Response response = given().when().get(url);

        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.statusLine());
        assertTrue(response.body().asString().contains("Not Found"));
        assertFalse(response.body().asString().contains("TechProEd"));
        assertEquals("Cowboy", response.getHeader("Server"));
    }
}
