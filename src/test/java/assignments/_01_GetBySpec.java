package assignments;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _01_GetBySpec extends JsonPlaceHolderBaseUrl {
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
    int id;

    @Test
    public void post01(){
        spec.pathParam("first", "todos");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 56);
        expectedData.put("title", "Clean your room");
        expectedData.put("completed", true);

        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        HashMap<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        id = (int) actualData.get("id");

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
    }

    @Test
    public void getbyid(){

    }

}
