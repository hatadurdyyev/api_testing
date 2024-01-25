package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class _01_RequestAndResponse {
    /*
        1) Postman is used for manual API testing
        2) We use RestAssured library for API Automation Testing.
        3) To type automation script follow these steps:
            a) Understand the requirement
            b) Type test cases
                To type the test cases we use 'Gherkin Language'
                The keywords are:
                    x) GIVEN: It is used for pre-condition
                    y) WHEN: It is used for actions (Requests...)
                    z) THEN: It is used for output (Assertion...)
                    t) AND: It is used for multiple usage of Given, When, and Then
            c) Start to type Automation Script
                i) Set the URL
                ii) Set the expected data
                iii) Send the request and get the response
                iv) Do assertion
     */
    /*
        Given
            https://restful-booker.herokuapp.com/booking/10
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    public static void main(String[] args) {
        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

        //response.prettyPrint();

        response.then().
                contentType("application/json").
                statusCode(200).statusLine("HTTP/1.1 200 OK");

        System.out.println(response.contentType());
        System.out.println(response.statusCode());
        System.out.println(response.jsonPath().toString());
        System.out.println(response.statusLine());
        System.out.println(response.headers());
        System.out.println(response.header("Server"));

    }
}
