package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderTestData.expectedDataMapMethod;

public class _01_Put extends JsonPlaceHolderBaseUrl {
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
    public void put01(){
        spec.pathParams("first", "todos", "second", 198);
        // 1st way:
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 123);
        expectedData.put("title", "Happy Potter");
        expectedData.put("completed", false);

        // 2nd way:
        Map<String, Object> expectedTestData = expectedDataMapMethod(124, "Better Call Saul", true);
//        I send PUT Request to the Url
        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);


//       Assert
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

    }
}
