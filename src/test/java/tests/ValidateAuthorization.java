package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import utils.Log;

public class ValidateAuthorization {

	@Test(enabled = false)
	public void validateAuthorization() {
		String token = given().auth().preemptive().basic("username", "password").when()
				.post("https://api.example.com/auth/token").then().statusCode(200).extract().path("access_token");

		Log.info("Authorization token retrieved successfully: " + token);

		// Validate token usage in an API request
		given().header("Authorization", "Bearer " + token).when().get("https://api.example.com/secure-endpoint").then()
				.statusCode(200);

		Log.info("Token-based authentication validated successfully.");
	}

}
