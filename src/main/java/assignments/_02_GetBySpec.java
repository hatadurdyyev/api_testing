package assignments;

import io.restassured.path.json.JsonPath;
import org.json.*;
import io.restassured.response.Response;
import org.junit.Test;
import get_urls.reqresPlaceHolderUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class _02_GetBySpec extends reqresPlaceHolderUrl{
    //Task01:
   /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    //Task02:
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */


    //Task03:
    //Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
    @Test
    public void Task01() {
        spec.pathParams("first", "api", "second", "unknown");

        Response response = given(spec).when().get("{first}/{second}");
        //response.prettyPrint();

        HashMap<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();

        List<String> pantone_value = jsonPath.getList("data.pantone_value");
        for (String x : pantone_value) {
            System.out.println(x);
        }

        List<Integer> ids = jsonPath.getList("data.id");
        int idsGreaterThan3 = 0;
        for (int x : ids) {
            if (x > 3) {
                System.out.println(x);
                idsGreaterThan3++;
            }
        }
        assertEquals(3, idsGreaterThan3);

        List<String> names = jsonPath.getList("data.name");
        List<String> nameList = new ArrayList<>();
        int namesLessThan3 = 0;
        for (int i = 0; i < 2; i++) {
                nameList.add(names.get(i));
                namesLessThan3++;
        }
        System.out.println(nameList);
        assertEquals(2, namesLessThan3);
    }

    @Test
    public void Task02() {
        spec.pathParams("first", "api", "second", "users");

        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");

        Response response = given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();

        HashMap<String, Object> actualData = response.as(HashMap.class);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("job"), actualData.get("job"));
    }
}
