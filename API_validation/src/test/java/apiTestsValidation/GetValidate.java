package apiTestsValidation;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetValidate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		RequestSpecification httprequest = RestAssured.given();
		// Response response = httprequest.request(Method.GET, "");
		Response response = httprequest.get("");
		int statusCode = response.getStatusCode();
		System.out.print(statusCode);
		
		System.out.println("Status received => " + response.getStatusLine()); 
		// System.out.println("Response=>" + response.prettyPrint());
		
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, 
	            "Correct status code should return");
		
		// Negative test cases
		response = httprequest.get("test");
		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, 
	            "Correct status code should return");
		
				

	}

}
