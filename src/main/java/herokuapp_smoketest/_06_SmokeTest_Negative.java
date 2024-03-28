package herokuapp_smoketest;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _06_SmokeTest_Negative extends herokuPlaceHolderUrl {
    @Test
    public void negative() {
        System.out.println("-----------NEGATIVE-----------");

        spec.pathParams("first", "booking", "second", "nope");

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        assertEquals(404, response.statusCode());
    }
}
