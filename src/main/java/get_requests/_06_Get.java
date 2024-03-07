package get_requests;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _06_Get extends herokuPlaceHolderUrl {
    @Test
    public void get06() {
        spec.pathParams("first", "booking", "second", 12);

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        /*
        assertEquals(200, response.statusCode());
        assertEquals("John", jsonPath.getString("firstname"));
        assertEquals("Smith", jsonPath.getString("lastname"));
        assertEquals(111, jsonPath.getInt("totalprice"));
        assertEquals(true, jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
        assertEquals("Breakfast", jsonPath.getString("additionalneeds"));
         */

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals("Jane", jsonPath.getString("firstname"), "firstname fail");
        softAssert.assertEquals("Doe", jsonPath.getString("lastname"),"lastname fail");
        softAssert.assertEquals(111, jsonPath.getInt("totalprice"),"totalprice fail");
        softAssert.assertEquals(true, jsonPath.getBoolean("depositpaid"),"depositpaid fail");
        softAssert.assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"), "checkin fail");
        softAssert.assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"),"checkout fail");
        softAssert.assertEquals("Extra pillows please", jsonPath.getString("additionalneeds"), "additionalneeds fail");

        softAssert.assertAll();
    }
}
