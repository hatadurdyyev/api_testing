package get_requests;

import get_urls.JSONPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _05_Get extends JSONPlaceHolderUrl {
    @Test
    public void get05() {
        spec.pathParam("first", "todos");

        Response response = given(spec).when().get("{first}");

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("", hasSize(200),
                        "title", hasItem("quis eius est sint explicabo"),
                        "userId", hasItems(2, 7, 9));
    }
}
