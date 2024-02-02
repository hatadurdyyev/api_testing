package assignments;

import get_urls.reqresPlaceHolderUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class _02_GetBySpec extends reqresPlaceHolderUrl {
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

        Response response = given(spec).when().get("{second}");
        response.prettyPrint();
    }
}
