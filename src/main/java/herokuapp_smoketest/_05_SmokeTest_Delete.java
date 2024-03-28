package herokuapp_smoketest;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest._01_SmokeTest_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _05_SmokeTest_Delete extends herokuPlaceHolderUrl {
    @Test
    public void delete() {
        System.out.println("-----------DELETE------------");

        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(201, response.statusCode());
    }
}
