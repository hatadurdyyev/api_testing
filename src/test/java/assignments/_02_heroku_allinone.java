package assignments;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class _02_heroku_allinone extends HerOkuAppBaseUrl {
    /*
        1. Post
        2. Get
        3. Put
        4. Patch
        5. Delete

        Given
            Url: https://restful-booker.herokuapp.com/booking
     */


    public int bookingId;

    @Test
    public void _01_post(){
        spec.pathParam("first", "booking");

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2018-01-01");
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 1234);
        expectedData.put("depositpaid", false);
        expectedData.put("bookingdates", bookingDates);
        expectedData.put("additionalneeds", "Breakfast");

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

    }

    @Test
    public void _02_get(){

    }

    @Test
    public void _03_put(){

    }

    @Test
    public void _04_patch(){

    }

    @Test
    public void _05_delete(){

    }

}
