import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _02_Get {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/10
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01_assertEquals(){
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/10");
        // 1st way by Java Knowledge
//        if ((response.statusCode()) == 200){
//            System.out.println("Status code is 200");
//        }

        //2nd way:
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());
        assertEquals("HTTP/1.1 200 OK", response.statusLine());
    }
    @Test
    public void get02_assertTrue(){
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/10");
        // 1st way by Java Knowledge
//        if ((response.statusCode()) == 200){
//            System.out.println("Status code is 200");
//        }

        //2nd way:
        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains("json"));
        assertTrue(response.statusLine().contains("OK"));
    }

}
