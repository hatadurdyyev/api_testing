import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _04_Get {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
        And
          Response format should be "application/json"
        And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
        And
          "completed" is false
        And
          "userId" is 2
    */
    @Test
    public void get04(){
        String url = "https://jsonplaceholder.typicode.com/todos/23";
        Response response = given().when().get(url);

        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        response.then().assertThat().
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));


    }
}
