package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _02_Post extends HerOkuAppBaseUrl {

    /*
    Given
            1)  https://restful-booker.herokuapp.com/booking
            2)   {
                "firstname": "John",
                "lastname": "Doe",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                },
                "additionalneeds": "Breakfast"
            }
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
            {
                            "bookingid": 16,
                            "booking" :{
                                     "firstname": "John",
                                     "lastname": "Doe",
                                     "totalprice": 999,
                                     "depositpaid": true,
                                     "bookingdates": {
                                         "checkin": "2021-09-21",
                                         "checkout": "2021-12-21"
                                     },
                                     "additionalneeds": "Breakfast"
                                  }
                               }
     */
    @Test
    public void post01(){
        spec.pathParam("first", "booking");
        BookingDatesPojo innerPojo = new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo expectedData = new BookingPojo("John", "Doe", 999, true, innerPojo, "Breakfast");

        Response response = given(spec).when().body(expectedData).post("{first}");
        response.prettyPrint();

        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);
        System.out.println(actualData.toString());

        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        // -- continue

    }
}
