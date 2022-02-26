import groovy.json.JsonBuilder;
import io.restassured.internal.http.HttpResponseDecorator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetMethods {
    @Test
    public void getCases01() throws Exception{

        try {
            Response response = get("http://10.9.0.29:8080/proSw/rest/apiv2/switch/get/balance/016000005054");
            ResponseBody body=response.getBody();
            System.out.println("balance is: "+body.asString());
        }catch (Exception e){
            System.out.println("Exception" +e);
        }




    }

    @Test
    public void getCases02(){
                given().
                        get("http://10.9.0.29:8080/proSw/rest/apiv2/switch/get/NID/info/19941314565000059/RBL").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void getCases03(){
        given().get("https://reqres.in/api/users?page=2").
                then().statusCode(200).
                body("data.id[0]", Matchers.equalTo(7)).
                log().all();

    }


}
