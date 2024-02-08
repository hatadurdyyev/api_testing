package assignments;

import get_urls.petstore_swagger_ioPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _03_GetBySpec extends petstore_swagger_ioPlaceHolderUrl{
    @Test
    public void Task03() {
        spec.pathParam("first", "user");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("id", 100);
        expectedData.put("username", "CatsHaveFeet");
        expectedData.put("firstName", "Andrei");
        expectedData.put("lastName", "Surubariu");
        expectedData.put("email", "and.surubariu@gmail.com");
        expectedData.put("password", "ABC123");
        expectedData.put("phone", "HTC One");
        expectedData.put("userStatus", 1);

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        HashMap<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
    }
}
