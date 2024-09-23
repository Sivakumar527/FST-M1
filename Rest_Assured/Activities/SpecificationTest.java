package Exapmples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpecificationTest {
    RequestSpecification requestSpoc;
    ResponseSpecification responseSpoc;

    int prtid;

    @BeforeClass
    public void setUp(){
        requestSpoc= new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type","application/json")
                .setAuth(oath2(""))


        responseSpoc=
    }

    @Test(priority = 1)
    public void postRequest(){

    }
    @Test(priority = 2)
    public void getRequest(){

    }
    @Test(priority = 3)
    public void deleteRequest(){

    }
}
