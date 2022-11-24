import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {
    @Test
    public void orderForPetTest(){
        String data="{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2022-11-23T14:06:02.439Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        given().contentType(ContentType.JSON).body(data).when().post("https://petstore.swagger.io/v2/store/order/").then().statusCode(200).time(lessThan(2000L));
    }


    @Test
    public void getOrderTest(){
        when().get("https://petstore.swagger.io/v2/store/order/1").then().statusCode(200).time(lessThan(2000L));
    }
}
