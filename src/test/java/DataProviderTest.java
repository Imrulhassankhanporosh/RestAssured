

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class DataProviderTest extends DataSetForTest {
//
//@DataProvider(name ="data to provide")
//    public Object[][] dataForTest(){
//        Object [][] data=new Object[2][3]; //[row number][column number]
//
//        data[0][0]="Mohaiminul";
//        data[0][1]="Islam";
//        data[0][2]="1";
//
//        data[1][0]="Enamul";
//        data[1][1]="Haque";
//        data[1][2]="11";
//
//        return data;
//
//    return new Object[][]{
//            {"Rafiul","Khan","4"},
//            {"Tahmeed","Ahmed","5"}
//    };
//    }
//
//    @DataProvider(name= "data to delete")
//    public Object[] dataForDelete(){
//    return new Object[]{
//            3
//    };
//    }

//    @Test(dataProvider="data to delete")
//    public void delete(int userID){
//
//        baseURI="http://localhost:3000/";
//
//        given().
//
//                delete("/users/"+userID).
//                then().
//                statusCode(200).
//                log().all();
//
//    }


@Test(dataProvider ="data to provide")
    public void localApi(String fname,String lname,String subjectID){
        JSONObject request = new JSONObject();

        request.put("firstName",fname);
        request.put("lastName",lname);
        request.put("subjectId",subjectID);
    //request.put("firstName","Imrul");
    //request.put("lastName","Hassan");
    //request.put("subjectId","331");



        System.out.println(request);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

}
