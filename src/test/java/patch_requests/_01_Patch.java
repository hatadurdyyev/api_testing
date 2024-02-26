package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderTestData.expectedDataMapMethod;

public class _01_Patch extends JsonPlaceHolderBaseUrl {
    /*
        Given
           1) https://jsonplaceholder.typicode.com/todos/198
           2) {
                "title": "Read the books"
              }
        When
            I send PATCH Request to the Url
        Then
             Status code is 200
             And response body is like   {
                                       "userId": 10,
                                       "title": "Read the books",
                                       "completed": true,
                                       "id": 198
                                      }
    */

    @Test
    public void patch01(){
        spec.pathParams("first","todos", "second", 198);

        Map<String, Object> expectedData = expectedDataMapMethod(null,"Read the books",null);
        Response response = given(spec).body(expectedData).when().patch("{first}/{second}");

        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("title"), actualData.get("title"));

    }
}
