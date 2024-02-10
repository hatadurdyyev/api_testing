package get_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.auth_HerOkuApp.tokenHerOkuApp;

public class herokuPlaceHolderUrl {
    protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().addHeader("Cookie", "token=" + tokenHerOkuApp()).setContentType(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com/").build();
    }
}
