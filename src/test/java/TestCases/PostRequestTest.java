package TestCases;

import Utilities.API_Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;


public class PostRequestTest {
    @BeforeClass
    public void startUp() throws IOException {
        API_Utils.readAPIConfigs();
        API_Utils.setBaseURL();
    }


//    @BeforeClass
//    public void setUp() throws IOException {
//        public static Properties getTestData () {
//            Properties prop = new Properties();
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "src/test/java/Resources/config.properties");
//            prop.load(fis);
//            System.out.println(prop.getProperty("name"));
//            System.out.println(prop.getProperty("lastname"));
//            System.out.println(prop.getProperty("location"));
//            System.out.println(prop.getProperty("status"));
//        }

        @Test
        public void createUser () throws IOException {

            System.out.println("inside get method");
            String endpoint="/api/register";
//            String endpoint=API_Utils.configs.getProperty("post_user_end_point");
            System.out.println("endpoint is ="+endpoint);
//            Response response=API_Utils.getRequest(endpoint);
//            System.out.println("inside post method");
//            String end_point = API_Utils.configs.getProperty("post_user_end_point");
//            System.out.println("after endpoint"+end_point);
            String body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\api_test_data\\CreateUserBody.json"), StandardCharsets.US_ASCII);
            System.out.println("body is="+body);


            Response response = API_Utils.postRequest(endpoint,body);

            System.out.println("after post method");

            Assert.assertEquals(response.getStatusCode(),201,"status code mismatch");


            String id =  response.getBody().jsonPath().getJsonObject("id").toString();

            String name =  response.getBody().jsonPath().getJsonObject("name").toString();
            
            String email =  response.getBody().jsonPath().getJsonObject("email").toString();
            String gender =  response.getBody().jsonPath().getJsonObject("gender").toString();
            String status =  response.getBody().jsonPath().getJsonObject("status").toString();

//            JsonMapper mapper = new JsonMapper();
//            JsonNode node = mapper.readValue(body, JsonNode.class);

            // method - 2
//            Assert.assertEquals(name, node.get("name").asText(),"name mismatch");

//            Assert.assertEquals(email, node.get("email").asText(),"email mismatch");

//            Assert.assertEquals(gender, node.get("gender").asText(),"gender mismatch");
//
//           Assert.assertEquals(status, node.get("status").asText(), "status mismatch");
        }
    }















