package TestCases;

import Utilities.API_Utils;

import io.restassured.response.Response;

import org.junit.BeforeClass;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

public class PostRequestTest {
    @BeforeClass
    public static void startUp() throws IOException {

        API_Utils.readAPIConfigs();

        API_Utils.setBaseURL();
    }
        @Test
        public void createUser () throws IOException {

            System.out.println("inside get method");

            String body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\api_test_data\\CreateUserBody.json"));

            System.out.println("body is="+body);

            Response response = API_Utils.postRequest( "https://reqres.in/api/users",body);

            System.out.println("after post method");

            Assert.assertEquals(response.getStatusCode(),201,"status code mismatch");

            System.out.println("after post method1");

            String id =  response.getBody().jsonPath().getJsonObject("id").toString();

            System.out.println("Id is ="+id);

            String name =  response.getBody().jsonPath().getJsonObject("name").toString();

            System.out.println("name is ="+name);

            String email =  response.getBody().jsonPath().getJsonObject("email").toString();

            System.out.println("email is ="+email);

            String gender =  response.getBody().jsonPath().getJsonObject("gender").toString();

            System.out.println("gender is ="+gender);

            String status =  response.getBody().jsonPath().getJsonObject("status").toString();

            System.out.println("status is ="+status);

        }
    }















