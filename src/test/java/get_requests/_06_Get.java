package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _06_Get extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/245
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
     */
    @Test
    public void get06(){
        spec.pathParams("first", "booking", "second", 5);
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        JsonPath jp = response.jsonPath();
        // Hard assertion
        /*assertEquals("John", jp.getString("firstname"));
        assertEquals("Smith", jp.getString("lastname"));
        assertEquals(111, jp.getInt("totalprice"));
        assertEquals(true, jp.getBoolean("depositpaid"));
        assertEquals("2018-01-01", jp.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", jp.getString("bookingdates.checkout"));*/

        // Soft assertion
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(jp.getString("firstname"), "Susan", "firstname didn't match");
        soft.assertAll();

    }
}
