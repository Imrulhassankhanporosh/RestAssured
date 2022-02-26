import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DeleteMethods {

    @Test
    public void deleteCases01(){
        List<String>list =new ArrayList<String>();
        list.add("017165068798");

        JSONArray arr= new JSONArray();
        for(int i =0;i<list.size();i++)
        {
            arr.add(list.get(i));
        }

        JSONObject request = new JSONObject();
        request.put("pushLessWalletList",arr);

        System.out.println(request);

      //  System.out.println(request.toString());

        Response response= (Response) given()
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .auth().preemptive()
                .basic("admin","SC@dm1n#AG")
                .when()
                .delete("http://10.9.0.29:4545/surecash-mobile-payment-api/api/admin/bulk/delete/pushLessWallet")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.getBody().asString());






    }
}
