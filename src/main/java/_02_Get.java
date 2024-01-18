import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class _02_Get {
    String url = "https://jsonplaceholder.typicode.com/todos/23";

    @Test
    public void get02() {
        Response response = given().when().get(url);

        assertEquals(200, response.statusCode());
        assertTrue(response.getContentType().contains("json"));
        assertTrue(response.body().asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));
        assertTrue(response.body().asString().contains("\"completed\": false"));
        assertTrue(response.body().asString().contains("\"userId\": 2"));
    }
}
