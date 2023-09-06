package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Q05 {
     /*

            *** Send a GET Request to https://reqres.in/api/users

                  test that:
                  The status code : 200
                  The content type : application/json; charset=utf-8

                  Bu dataların varlığını test edin :
                  email : tracey.ramos@reqres.in
                  first_name : Tracey
                  last_name : Ramos
                  avatar : https://reqres.in/img/faces/6-image.jpg


                {
                    "id": 6,
                    "email": "tracey.ramos@reqres.in",
                    "first_name": "Tracey",
                    "last_name": "Ramos",
                    "avatar": "https://reqres.in/img/faces/6-image.jpg"
                 }
         */
    @Test
    public void test(){
        Response response=given().when().get("https://reqres.in/api/users");
        response.prettyPrint();
        response
                .then()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .statusCode(200)
                .body("data[5].id",equalTo(6),
                        "data[5].email",equalTo("tracey.ramos@reqres.in"),
                        "data[5].first_name",equalTo("Tracey"),
                        "data[5].last_name",equalTo("Ramos"),
                        "data[5].avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"),
                        "support.url",equalTo("https://reqres.in/#support-heading"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")

                );
    }

}
