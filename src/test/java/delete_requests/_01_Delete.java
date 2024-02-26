package delete_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _01_Delete extends JsonPlaceHolderBaseUrl {
    /*
        Given
           url : https://jsonplaceholder.typicode.com/todos/198
        When
            I send DELETE Request to the Url
        Then
             Status code is 200
    */

    @Test
    public void delete01(){
        spec.pathParams("first", "todos", "second", 192);
        Response response = given(spec).when().delete("{first}/{second}");

        assertEquals(200, response.statusCode());
    }
}
