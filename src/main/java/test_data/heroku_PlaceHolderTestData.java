package test_data;

import java.util.HashMap;
import java.util.Map;

public class heroku_PlaceHolderTestData {
    public static Map<String, String> bookingMapMethod(String checkin, String checkout) {
        Map<String, String> bookingdates = new HashMap<>();

        if (checkin != null) {
            bookingdates.put("checkin", checkin);
        }

        if (checkout != null) {
            bookingdates.put("checkout", checkout);
        }

        return bookingdates;
    }

    public static Map<String, Object> expectedDataMapMethod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {
        Map<String, Object> expectedData = new HashMap<>();

        if (firstname != null) {
            expectedData.put("firstname", firstname);
        }

        if (lastname != null) {
            expectedData.put("lastname", lastname);
        }

        if (totalprice != null) {
            expectedData.put("totalprice", totalprice);
        }

        if (depositpaid != null) {
            expectedData.put("depositpaid", depositpaid);
        }

        if (bookingdates != null) {
            expectedData.put("bookingdates", bookingdates);
        }

        if (additionalneeds != null) {
            expectedData.put("additionalneeds", additionalneeds);
        }

        return expectedData;
    }
}