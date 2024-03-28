package herokuapp_smoketest;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest._01_SmokeTest_Post.bookingId;
import static herokuapp_smoketest._01_SmokeTest_Post.putData;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _03_SmokeTest_Put extends herokuPlaceHolderUrl {
    @Test
    public void put() {
        System.out.println("-----------PUT-----------");

        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).body(putData).when().put("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(putData.get("firstname"), actualData.get("firstname"));
        assertEquals(putData.get("lastname"), actualData.get("lastname"));
        assertEquals(putData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(putData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map<String, Object>)putData.get("bookingdates")).get("checkin"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkin"));
        assertEquals(((Map<String, Object>)putData.get("bookingdates")).get("checkout"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkout"));
        assertEquals(putData.get("additionalneeds"), actualData.get("additionalneeds"));
    }
}
