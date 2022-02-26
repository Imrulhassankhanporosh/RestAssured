import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PutMethods {
@Test
    public void putCases01(){
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("wallet", "017165068798");
    map.put("purposeOfTxn", "RETAILER");
    map.put("operation","ADD");

    JSONObject request = new JSONObject(map);
    System.out.println(request);

    Response response =given()
            .header("Content-type","application/json")
            .body(request.toJSONString())
            .when()
            .put("http://10.9.0.29:8080/proSw/rest/apiv3/switch/wallet/update/tag")
            .then()
            .extract().response();

    System.out.println(response.getBody().asString());

}
}
