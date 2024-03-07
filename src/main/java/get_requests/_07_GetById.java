package get_requests;

import get_urls.herokuPlaceHolderUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class _07_GetById extends herokuPlaceHolderUrl {
    @Test
    public void getbyid() {
        spec.pathParam("first", "booking");

        Response response = given(spec).when().get("{first}");
        //response.prettyPrint();

        ArrayList<Integer> actualData = response.as(ArrayList.class);
        System.out.println(actualData.size());
        Iterator<Integer> iterator = actualData.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
