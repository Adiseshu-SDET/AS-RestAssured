package tests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import utils.Log;

public class ValidatePagination {

	@Test(enabled = false)
	public void validatePagination() {
		int totalPages = given().queryParam("page", 1).when().get("https://api.example.com/items").then()
				.statusCode(200).extract().path("total_pages");

		for (int i = 1; i <= totalPages; i++) {
			Response response = given().queryParam("page", i).when().get("https://api.example.com/items");

			Log.info("Page " + i + " response: " + response.asPrettyString());
			response.then().statusCode(200);
		}

		Log.info("Pagination validated successfully across all pages.");
	}
}
