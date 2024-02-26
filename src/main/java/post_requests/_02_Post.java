package post_requests;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.bookingDatesPojo;
import pojos.bookingPojo;
import pojos.bookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _02_Post extends herokuPlaceHolderUrl {

    @Test
    public void post01() {
        spec.pathParam("first", "booking");
        bookingDatesPojo innerPojo = new bookingDatesPojo("2024-04-07", "2024-04-27");
        bookingPojo expectedData = new bookingPojo("John", "Kaczynski", 499, false, innerPojo, "Cookies");

        Response response = given(spec).body(expectedData).when().post("{first}");

        response.prettyPrint();

        bookingResponsePojo actualData = response.as(bookingResponsePojo.class);
        System.out.println(actualData.toString());

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
    }
}
