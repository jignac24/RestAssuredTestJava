package apiTestsValidation;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiEndpoints.Utilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class postCallTest {
	
	RequestSpecification httprequest;
	Response response;
	Headers headers;
	ResponseBody body;
	int statusCode;
	
	JsonPath jsonPathEvaluator;
	
	Utilities uPage = new Utilities();
	String email = uPage.generateRandomString(5) + "@gmail.com";
	String userDetails;
	
	@Test
	public void verify_post_call() 
	{
		  RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		  httprequest = RestAssured.given();		  
		  
		  // httprequest.header("Content-Type", "application/x-www-form-urlencoded");
		  httprequest.header("Authorization", "Bearer 462e9984f3ddce7141955984cad598d4026c56f8014fa2a545183376affae41d");
	      String payload = "{"
	                + "\"name\": \"John Doe\","
	                + "\"email\": \"" + email + "\","
	                + "\"gender\": \"male\","
	                + "\"status\": \"active\""
	                + "}";
	      
	      httprequest.body(payload);
	      httprequest.contentType(ContentType.JSON);
	      response = httprequest.request(Method.POST, "");
	       
		  statusCode = response.getStatusCode();
		  Assert.assertEquals(statusCode /*actual value*/, 201 /*expected value*/, 
		            "Correct status code should return"); 
		  // userDetails = response.getBody().asPrettyString();
		  
		  System.out.println("Response Status Code: " + response.getStatusCode());
	      System.out.println("Response Body: " + response.getBody().asPrettyString());	  
	      
		  jsonPathEvaluator = response.jsonPath();
		  
		  // Then simply query the JsonPath object to get a String value of the node
		  int userId = jsonPathEvaluator.get("id");
		  System.out.println("Name received from Response = " + userId);
		  
		  
		  // Verify created user via GET Method
		  response = httprequest.request(Method.GET, "/" + userId);
		  body = response.getBody();
		  int user_id = jsonPathEvaluator.get("id");
		  Assert.assertEquals(userId, user_id, "Correct user id received in the Response");

	  
 	}
}
