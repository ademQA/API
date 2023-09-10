package API_Testing;

import baseURL.baseURLDummy;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Odev2_Page_147 extends baseURLDummy {
    /*
    C20_Get_TestDataKullanimi
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde donen
response’un status code’unun 200, content Type’inin application/json ve body’sinin asagidaki gibi
 oldugunu test edin.

Response Body
{
"status": "success", "data": {
"id": 3,
"employee_name": "Ashton Cox", "employee_salary": 86000, "employee_age": 66, "profile_image": ""
},
"message": "Successfully! Record has been fetched." }
     */
    @Test
    public void get01(){
        specDummy.pathParams("pp1","api","v1",44,"pp1","employee","pp2",3);

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.then().assertThat()
                .statusCode(200)
                .body("status",equalTo("success"),
                        "data.id",equalTo(3),
                        "data.employee_name",equalTo("Ashton Cox"),
                        "data.employee_salary",equalTo(86000),
                        "data.employee_age",equalTo(66)

                        );


    }
}
