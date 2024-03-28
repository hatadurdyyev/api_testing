package herokuapp_smoketest;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest._01_SmokeTest_Post.bookingId;
import static herokuapp_smoketest._01_SmokeTest_Post.patchData;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _04_SmokeTest_Patch extends herokuPlaceHolderUrl {
    @Test
    public void patch() {
        System.out.println("-----------PATCH------------");

        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).body(patchData).when().patch("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(patchData.get("lastname"), actualData.get("lastname"));
        assertEquals(patchData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(patchData.get("additionalneeds"), actualData.get("additionalneeds"));
    }
}
