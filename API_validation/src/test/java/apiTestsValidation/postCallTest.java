package apiTestsValidation;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiEndpoints.Utilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class postCallTest {
	
	RequestSpecification httprequest;
	Response response;
	Headers headers;
	ResponseBody body;
	int statusCode;
	
	Utilities uPage = new Utilities();
	String email = uPage.generateRandomString(5) + "@gmail.com";
	
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
		  
		  System.out.println("Response Status Code: " + response.getStatusCode());
	      System.out.println("Response Body: " + response.getBody().asPrettyString());	  
	  
 	}
}
