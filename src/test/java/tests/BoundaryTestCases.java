package tests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import utils.Log;

public class BoundaryTestCases {

	@Test
	public void validateBoundaryConditions() {
		// Minimum value
		given().queryParam("age", 0).when().get("https://jsonplaceholder.typicode.com/users/1").then().statusCode(200);

		Log.info("Minimum boundary condition validated successfully.");

		// Maximum value
		given().queryParam("age", 150).when().get("https://jsonplaceholder.typicode.com/users/1").then().statusCode(200);

		Log.info("Maximum boundary condition validated successfully.");
	}

}
