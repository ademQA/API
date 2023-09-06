package API_Testing;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Q01 {
      /*
     C1_Get_ApiSorgulama
     https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
     gonderdigimizde donen Response’un,
     status code’unun 200,
     ve content type’inin application/json; charset=utf-8, ve Server isimli Header’in degerinin Cowboy,
     ve status Line’in HTTP/1.1 200 OK
     ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
      */
    @Test
    public void test(){
        Response response=given().when().get("https://restful-booker.herokuapp.com/booking/10");
        response.prettyPrint();
        response
                .then()
                .assertThat()
                .contentType("application/json")
                .statusCode(200)
                .body("firstname",equalTo("Jim"),
               "lastname",equalTo("Smith"),
              "totalprice",equalTo(829),
               "depositpaid",equalTo(true),
                "bookingdates.checkin",equalTo("2015-07-16"),
                        "bookingdates.checkout",equalTo("2019-01-06")
                        );



    }


}
