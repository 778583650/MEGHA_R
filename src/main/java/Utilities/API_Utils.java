package Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class API_Utils {
    public static Properties configs;
    public static RequestSpecification request;

    public static Response response;

    public static void readAPIConfigs() throws IOException {
        System.out.println("inside readAPIConfigs");
        configs = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config.properties");
        System.out.println("after readAPIConfigs");
        configs.load(fs);
        System.out.println("after load readAPIConfigs");
    }

    public static void setBaseURL() throws IOException {

        RestAssured.baseURI = configs.getProperty("base_url");

    }


    public static Response getRequest(String endpoint) {

        RestAssured.given();

        request.header("Content-Type", "application/json");

        response = request.get(endpoint);

        return response;
    }

//    private static String getToken() {
//        //make an auth API call to get token if available
//        String token = API_Utils.configs.getProperty("access_token");
//        return token;
//    }

    public static Response postRequest(String endpoint,String formdata) {

        request = RestAssured.given();

        request.header("Content-type", "application/json");

        request.body(formdata);

        response = request.post(endpoint);

        return response;
    }

//    public static Response postRequest1(String endpoint, String formdata) {
//        return given()
//                .contentType(ContentType.JSON).
//                config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("ContentType.JSON", ContentType.TEXT))).
//                body(formdata).
//                post(endpoint);
//    }


}