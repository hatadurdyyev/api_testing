package herokuapp_smoketest;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest._01_SmokeTest_Post.bookingId;
import static herokuapp_smoketest._01_SmokeTest_Post.expectedData;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _02_SmokeTest_Get extends herokuPlaceHolderUrl {
    @Test
    public void get() {
        System.out.println("-----------GET-----------");

        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map<String, Object>)expectedData.get("bookingdates")).get("checkin"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkin"));
        assertEquals(((Map<String, Object>)expectedData.get("bookingdates")).get("checkout"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
    }
}
