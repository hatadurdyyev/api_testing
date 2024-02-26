package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {
    // This method creates a map for inner json
    public static Map<String, String> bookingDataMapMethod(String checkin, String checkout){
        Map<String,String> bookingDatesMap = new HashMap<>();
        if (checkin != null){
            bookingDatesMap.put("checkin", checkin);
        }
        if (checkout != null){
            bookingDatesMap.put("checkout", checkout);
        }

        return bookingDatesMap;
    }

    // This method creates a map for outer json
    public static Map<String, Object> expectedDataMethod(String firstname, String lastname,
                                                         Integer totalprice, Boolean depositpaid,
                                                         Map<String, String> bookingdates, String additionalneeds){
        Map<String, Object> expectedData = new HashMap<>();
        if (firstname != null){
            expectedData.put("firstname",firstname);
        }
        if (lastname != null){
            expectedData.put("lastname",lastname);
        }
        if (totalprice != null){
            expectedData.put("totalprice",totalprice);
        }
        if (depositpaid != null){
            expectedData.put("depositpaid",depositpaid);
        }
        if (bookingdates != null){
            expectedData.put("bookingdates",bookingdates);
        }
        if (additionalneeds != null){
            expectedData.put("additionalneeds",additionalneeds);
        }

        return expectedData;
    }
}
