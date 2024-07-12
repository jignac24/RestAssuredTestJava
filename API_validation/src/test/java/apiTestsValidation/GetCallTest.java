package apiTestsValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetCallTest {	
	
	RequestSpecification httprequest;
	Response response;
	Headers headers;
	ResponseBody body;
	int statusCode;

  @Test
  public void verify_Get1() 
  {
	  
	  RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	  httprequest = RestAssured.given();
	  response = httprequest.request(Method.GET, "");
	  statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, 
	            "Correct status code should return"); 

  }
  @Test
  public void verify_Get2()
  {
	  RestAssured.baseURI = "https://gorest.co.in/public/v2/user";
	  httprequest = RestAssured.given();
	  response = httprequest.request(Method.GET, "");
	  statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode /*actual value*/, 404 /*expected value*/, 
	            "Correct status code should return"); 	
	  
  }
  
  @Test
  public void verify_all_Headers()
  {
	  RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	  httprequest = RestAssured.given();
	  response = httprequest.request(Method.GET, "");
	  headers = response.headers();
	  for(Header header : headers) {
		  System.out.println( header.getName() + " == " + header.getValue()); 
	  }
	  
  }
  @Test
  public void verify_Header()
  {
	  RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	  httprequest = RestAssured.given();
	  response = httprequest.request(Method.GET, "/7026305");
	  headers = response.headers();
	  String contentType = response.header("Content-Type"); 
	  Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */); 
	  
  }
  
  @Test
  public void verify_body()
  {
	  RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	  httprequest = RestAssured.given();
	  response = httprequest.request(Method.GET, "/7026305");
	  body = response.getBody();
	  // System.out.println("Response Body is: " + body.asString());
	  System.out.println("Response => " + response.prettyPrint());

  }
  
  @Test
  public void verify_jsonbody()
  {
	  RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	  httprequest = RestAssured.given();
	  response = httprequest.request(Method.GET, "/7026305");
	  body = response.getBody();
	  
	  // First get the JsonPath object instance from the Response interface
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  
	  // Then simply query the JsonPath object to get a String value of the node
	  String name = jsonPathEvaluator.get("name");
	  System.out.println("Name received from Response = " + name);
	  Assert.assertEquals(name, "Dhruv Bandopadhyay", "Correct name received in the Response");

  }
  
  
  
}
