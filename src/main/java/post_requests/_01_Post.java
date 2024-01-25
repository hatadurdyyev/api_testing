package post_requests;

import get_urls.JSONPlaceHolderUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class _01_Post extends JSONPlaceHolderUrl {
    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post01(){
        spec.pathParam("first", "todos");

        Map<String, Object> expectedData = new LinkedHashMap<>();
        expectedData.put("userId", 55);
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed", false);

        //System.out.println(expectedData);

        Response response = given().spec(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        LinkedHashMap<String, Object> actualData = response.as(LinkedHashMap.class);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
    }
}