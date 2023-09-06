package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Q01 {
     /*
        url : https://reqres.in/api/users/
        get request

        dönen response yazdırın
         */
    @Test
             public void test01(){
        Response response=given().when().get("https://reqres.in/api/users/");
        response.prettyPrint();
    }

}
