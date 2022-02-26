import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class PostMethods {

    @Test
    public void postCases01(){
       // Map<String,Object> map=new HashMap<String,Object>();

       // map.put("name",null);
       // map.put("uuid","fec250fb-8f5c-4775-9b00-84a7c06fd25f");
       // map.put("device_id","ae532adec8607de6");
      //  map.put("device_type",null);
       // map.put("mobile_number","01660660762");

        //System.out.println(map);
       // JSONObject request=new JSONObject(map);
       // System.out.println(request);

        JSONObject request=new JSONObject();
        request.put("name",null);
        request.put("uuid","fec250fb-8f5c-4775-9b00-84a7c06fd25f");
        request.put("device_id","ae532adec8607de6");
        request.put("device_type",null);
        request.put("mobile_number","01350660462");

        System.out.println(request);

        Response response = given()
                .header("Content-type", "application/json")
                //.and()
                .body(request.toJSONString())
                .when()
                .post("http://10.9.0.41:8080/nobopay-api-gateway/api/v1/user/signup/attempt")
                .then()
                .extract().response();

        System.out.println("Response:"+response.getBody().asString());
        System.out.println("Statuscode:"+response.getStatusCode());

//        Response response= request.post("http://10.9.0.41:8080/nobopay-api-gateway/api/v1/user/signup/attempt");
////        ResponseBody body= response.getBody();
//        System.out.println(response.getStatusCode());


    }

    @Test
    public void postCases02(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("otp","123545");
        map.put("mobile_number","01350660462");
        map.put("otp_type","REGISTRATION");

        JSONObject request=new JSONObject(map);
        System.out.println(request);

        Response response= (Response) given()
                .header("Content-type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("http://10.9.0.41:8080/nobopay-api-gateway/api/v1/user/otp/verify")
                .then()
                .extract().response();

        System.out.println(response.getBody().asString());

    }


    @Test
    public void postCases03(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name", "Mahi");
        map.put("pin","2270");
        map.put("role","CUSTOMER");
        map.put("uuid","fec250fb-8f5c-4775-9b00-84a7c06fd25f");
        map.put("biller_code","");
        map.put("device_id","ae532adec8607de6");
        map.put("mobile_number","01350660462");

        JSONObject request=new JSONObject(map);
        System.out.println(request);

        Response response= (Response) given()
                .header("Content-type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("http://10.9.0.41:8080/nobopay-api-gateway/api/v1/user/signup/wallet")
                .then()
                .extract().response();

        System.out.println(response.getBody().asString());

    }



}
