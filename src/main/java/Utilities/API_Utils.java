package Utilities;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

public class API_Utils {
    public static Properties configs;
    public static RequestSpecification request;
    public static Response response;
    public static void readAPIConfigs() throws IOException {

        configs = new Properties();

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config.properties");

        configs.load(fs);

    }
    public static void setBaseURL() throws IOException {

        RestAssured.baseURI = configs.getProperty("base_url");

    }
    public static Response getRequest(String endpoint) {

        request = RestAssured.given();

        RestAssured.given();

        request.header("Content-Type", "application/json");

        response = request.get("https://reqres.in/api/users?page=2");

        return response;
    }

    public static Response postRequest(String endpoint,String formdata) {

        request = RestAssured.given();

        request.header("Content-type", "application/json");

        request.body(formdata);

        response = request.post(endpoint);

        return response;
    }

}