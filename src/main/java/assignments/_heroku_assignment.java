package assignments;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.heroku_PlaceHolderTestData.bookingMapMethod;
import static test_data.heroku_PlaceHolderTestData.expectedDataMapMethod;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class _heroku_assignment extends herokuPlaceHolderUrl {

    public static int bookingId;

    public static Map<String, String> bookingdates = bookingMapMethod("2024-04-07", "2024-04-27");
    public static Map<String, String> putdates = bookingMapMethod("1988-08-21", "1999-04-01");
    public static Map<String, Object> expectedData = expectedDataMapMethod("John", "Kaszynski", 499, false, bookingdates, "Cookies");
    public static Map<String, Object> putData = expectedDataMapMethod("James", "Mogan", 1099, true, putdates, "Meth :)");
    public static Map<String, Object> patchData = expectedDataMapMethod(null, "Brogan", null, false, null, "MDMA :)");
    @Test
    public void Apost() {
        spec.pathParam("first", "booking");

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        bookingId = jsonPath.getInt("bookingid");
        //System.out.println(bookingId);
        Map<String, Object> actualData = jsonPath.getMap("booking");

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map<String, Object>)expectedData.get("bookingdates")).get("checkin"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkin"));
        assertEquals(((Map<String, Object>)expectedData.get("bookingdates")).get("checkout"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
    }

    @Test
    public void Bget() {
        //System.out.println(bookingId);
        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map<String, Object>)expectedData.get("bookingdates")).get("checkin"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkin"));
        assertEquals(((Map<String, Object>)expectedData.get("bookingdates")).get("checkout"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
    }

    @Test
    public void Cput() {
        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).body(putData).when().put("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(putData.get("firstname"), actualData.get("firstname"));
        assertEquals(putData.get("lastname"), actualData.get("lastname"));
        assertEquals(putData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(putData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map<String, Object>)putData.get("bookingdates")).get("checkin"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkin"));
        assertEquals(((Map<String, Object>)putData.get("bookingdates")).get("checkout"), ((Map<String, Object>)actualData.get("bookingdates")).get("checkout"));
        assertEquals(putData.get("additionalneeds"), actualData.get("additionalneeds"));
    }

    @Test
    public void Dpatch() {
        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).body(patchData).when().patch("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(patchData.get("lastname"), actualData.get("lastname"));
        assertEquals(patchData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(patchData.get("additionalneeds"), actualData.get("additionalneeds"));
    }

    @Test
    public void Edelete() {
        spec.pathParams("first", "booking", "second", bookingId);

        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(201, response.statusCode());
    }
}
