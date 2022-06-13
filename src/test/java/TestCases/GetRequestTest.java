package TestCases;

import Utilities.API_Utils;

import io.restassured.response.Response;

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

//      Specify get user end point
        endpoint=API_Utils.configs.getProperty("get_user_end_point");

        Response response=API_Utils.getRequest(endpoint);

        System.out.println("after response in vertical="+response.asPrettyString());

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