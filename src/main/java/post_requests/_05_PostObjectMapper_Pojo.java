package post_requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import get_urls.JSONPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JSONPlaceHolderPojo;
import pojos.JSONPlaceHolderResponse;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _05_PostObjectMapper_Pojo extends JSONPlaceHolderUrl {
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
    public void post06() throws JsonProcessingException {
        spec.pathParam("first", "todos");
        JSONPlaceHolderPojo expectedData = new JSONPlaceHolderPojo(55, "Tidy your room", false);

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        JSONPlaceHolderPojo actualData = new ObjectMapper().readValue(response.asString(), JSONPlaceHolderPojo.class);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());

    }
}
