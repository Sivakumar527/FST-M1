package Exapmples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class FirstTest {


 //   https://petstore.swagger.io/
    @Test
    public void getRequestWithQueryParam(){
                Response response =
                        given().
                             baseUri("https://petstore.swagger.io//v2/pet/").
                                header("Content-Type","application/json").
                                queryParam("status","alive").

                        when().
                                get("/findByStatus");

        System.out.println(response.getHeaders());
        System.out.println(response.getBody().asString());

        System.out.println(response.getBody().asPrettyString());
        String petStatus=response.then().extract().path("[0=].status");


        Assert.assertEquals(petStatus,"alive");
    }

    @Test
    public void getRequestWithQueryParam() {
        given().
                baseUri("https://petstore.swagger.io//v2/pet/").
                header("Content-Type", "application/json").
                queryParam("status", "alive").
                pathParam("petId", 77232).
                log.all().
        when().
                get("/{petId}").
        then().
                Statuscstatusde(200).
                body("Status",equalTo(petStatus));
        response.then().body


    }
}
