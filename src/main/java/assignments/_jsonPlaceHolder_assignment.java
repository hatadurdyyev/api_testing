package assignments;

import get_urls.JSONPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JSONPlaceHolderPojo;
import pojos.JSONPlaceHolderResponse;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _jsonPlaceHolder_assignment extends JSONPlaceHolderUrl{
    @Test
    public void post01() {
        spec.pathParam("first", "todos");
        JSONPlaceHolderPojo expectedData = new JSONPlaceHolderPojo(55, "Tidy your room", false);

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        JSONPlaceHolderResponse actualData = response.as(JSONPlaceHolderResponse.class);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(201, actualData.getId().longValue());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());
    }
}
