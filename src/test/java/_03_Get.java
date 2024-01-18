import io.restassured.response.Response;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class _03_Get {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
    */

    @Test
    public void get03(){
        //i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/0";

        //ii) Set the expected data
        //iii) Send the request and get the response
        Response response = given().when().get(url);

        //iv) Do assertion
        assertEquals(404, response.statusCode());
        assertTrue(response.statusLine().contains("HTTP/1.1 404 Not Found"));
        assertTrue(response.body().asString().contains("Not Found"));
        assertFalse(response.body().asString().contains("TechProEd"));
        assertEquals("Cowboy", response.header("Server"));


    }


}
