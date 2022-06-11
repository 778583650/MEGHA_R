package TestCases;

import Utilities.API_Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class GetRequestTest {

    String endpoint;
    @BeforeClass
    public void startUp() throws IOException {
        API_Utils.readAPIConfigs();
        API_Utils.setBaseURL();
    }

    @Test
    public void getAllUsers(){


        System.out.println("inside get method");

        endpoint=API_Utils.configs.getProperty("get_user_end_point");
        System.out.println("endpoint is ="+endpoint);

        Response response=API_Utils.getRequest(endpoint);

        System.out.println("after response in vertical="+response.asPrettyString());
//        specify base URI:
//        RestAssured.baseURI = "https://reqres.in/";

//                Represents request object
//        RequestSpecification httprequest = RestAssured.given();
//                response object
//        Response response = httprequest.request(Method.GET, "/api/users?page=2");
//                print response in console
        String responseBody = response.getBody().asString();



        System.out.println("Response Body is=" + responseBody);
//        status code validation
        int statusCode= response.getStatusCode();


        System.out.println("Status Code is=" +statusCode );


        Assert.assertEquals(statusCode,200);

//        status line verification
        String StatusLine=response.getStatusLine();

        System.out.println("Status Line is=" + StatusLine);
    }
}