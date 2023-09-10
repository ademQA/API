package API_Testing;

import baseURL.baseURL_JSONHolder;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Odev1_Page_137 extends baseURL_JSONHolder {

    /*
    C15_BaseUrlJsonPlaceHolder
Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde donen
response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde donen
response’un status code’unun 200 oldugunu ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request gonderdigimizde donen
 response’un status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin
     */

    @Test
    public void get01(){
      //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
        //1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde donen
        //response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin
        specJsonHolder.pathParams("pp1","posts");

        Response response=given().spec(specJsonHolder).when().get("/{pp1}");
        response.then().assertThat()
                .statusCode(200)
                .body("tittle",hasSize(100));
    }

    @Test
    public void get02(){
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde donen
        //response’un status code’unun 200 oldugunu ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
        specJsonHolder.pathParams("pp1","posts","pp2",44);

        Response response=given().spec(specJsonHolder).when().get("/{pp1}/{pp2}");

        response.then().assertThat()
                .statusCode(200)
                .body("tittle",equalTo("optio dolor molestias sit"));

    }

    @Test
    public void delete01(){
          /*
        3-https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
	    gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
        body’sinin null oldugunu test edin
         */
        specJsonHolder.pathParams("pp1","posts","pp2",50);

        Response response=given().spec(specJsonHolder).delete("/{pp1}/{pp2}");

        response.then().assertThat()
                .statusCode(200)
                .body("title",nullValue());


    }
}
