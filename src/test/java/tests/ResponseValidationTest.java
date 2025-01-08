package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentReportManager;
import utils.Log;
import utils.RequestBuilder;
import utils.ResponseValidator;

import java.util.HashMap;
import java.util.Map;

public class ResponseValidationTest extends BaseTest {

	
   
	@Test(groups = {"Smoke"})
	public void testGetUserValidation() {

		// Create ExtentTest instance for this test
//		extent = ExtentReportManager.createTest("Get User Validation", "Validate GET /users/1 endpoint");

		// Build and send GET request
		Response response = RequestBuilder.buildGetRequest(null, null)
				.get("https://jsonplaceholder.typicode.com/users/1");

		Log.info("Sending GET request to /users/1");
		
		// Log response
		response.then().log().all();
		Log.info("Response received: " + response.asPrettyString());
		// Validate response
		ResponseValidator.validateStatusCode(response, 200);
		ResponseValidator.validateContentType(response, "application/json; charset=utf-8");
		ResponseValidator.validateField(response, "name", "Leanne Graham");
	}

	@Test(groups = {"Regression"})
	public void testPostRequestValidation() {

		// Create ExtentTest instance for this test
//		extent = ExtentReportManager.createTest("Get User Validation", "Validate GET /users/1 endpoint");
		// Request body
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("title", "foo");
		requestBody.put("body", "bar");
		requestBody.put("userId", 1);

		// Build and send POST request
		Response response = RequestBuilder.buildPostRequest(null, null, requestBody)
				.post("https://jsonplaceholder.typicode.com/posts");

		// Log response
		response.then().log().all();

		// Validate response
		ResponseValidator.validateStatusCode(response, 201);
		ResponseValidator.validateField(response, "title", "foo");
		ResponseValidator.validateField(response, "body", "bar");
		ResponseValidator.validateField(response, "userId", 1);
	}
}
