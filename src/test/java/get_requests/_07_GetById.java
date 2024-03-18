package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static io.restassured.RestAssured.given;

public class _07_GetById extends HerOkuAppBaseUrl {
    @Test
    public void getById(){
        spec.pathParam("first", "booking");
        Response response = given(spec).when().get("{first}");

        ArrayList<Object> list = response.as(ArrayList.class);
        System.out.println(list.size());

        for (Object x : list) {
            System.out.println(x);
        }

        System.out.println("----------------------------------");
        System.out.println(list.size());
        Iterator<Object> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
