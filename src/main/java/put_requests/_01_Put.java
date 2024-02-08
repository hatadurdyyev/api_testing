package put_requests;

import get_urls.JSONPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import test_data.JSON_PlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _01_Put extends JSONPlaceHolderUrl{
    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
        I send PUT Request to the Url
    Then
        Status code is 200
        And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
    */

    @Test
    public void put01() {
        spec.pathParams("first", "todos", "second", 148);

        Map<String, Object> expectedData = JSON_PlaceHolderTestData.expectedDataMapMethod(123, "Wash the dishes", false);

        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(actualData.get("userId"), expectedData.get("userId"));
        assertEquals(actualData.get("title"), expectedData.get("title"));
        assertEquals(actualData.get("completed"), expectedData.get("completed"));
    }
}
