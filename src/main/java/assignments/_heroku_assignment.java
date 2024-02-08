package assignments;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.heroku_PlaceHolderTestData.bookingMapMethod;
import static test_data.heroku_PlaceHolderTestData.expectedDataMapMethod;

public class _heroku_assignment extends herokuPlaceHolderUrl {
    @Test
    public void post() {
        spec.pathParams("first", "booking", "second", 455);
        Map<String, String> bookingdates = bookingMapMethod("2024-04-07", "2024-04-27");
        Map<String, Object> expectedData = expectedDataMapMethod("John", "Kaszynski", 499, false, bookingdates, "Cookies");

        Response response = given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());
    }
}
