import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TestGet01 {

    @Test

    void testGet01(){
        Response response= RestAssured.get("http://10.9.0.29:8080/proSw/rest/apiv2/switch/get/NID/info/19941314565000059/RBL");
        int statusCode= response.getStatusCode();
        Assert.assertEquals(statusCode,200);


    }

    @Test
    public void testGet02(){
        given().get("http://10.9.0.29:8080/proSw/rest/apiv2/switch/get/NID/info/19941314565000059/RBL").
                then().
                statusCode(200).
                log().all();
    }

}
