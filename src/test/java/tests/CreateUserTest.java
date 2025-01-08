package tests;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.ExcelReader;
import utils.JsonDataReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateUserTest extends BaseTest {

	@DataProvider(name = "userData")
	public Object[][] getUserData() {
		return new Object[][] { { "John", "john.doe@example.com", "1234 Main St" },
				{ "Jane", "jane.smith@example.com", "5678 Elm St" },
				{ "Alice", "alice.johnson@example.com", "9102 Oak St" } };
	}

	@DataProvider(name = "userDataFromJson")
	public Object[][] getUserDataFromJson() throws IOException {
		List<Map<String, String>> testData = JsonDataReader.getTestData("src/main/resources/userData.json");
		Object[][] data = new Object[testData.size()][3];
		for (int i = 0; i < testData.size(); i++) {
			data[i][0] = testData.get(i).get("name");
			data[i][1] = testData.get(i).get("email");
			data[i][2] = testData.get(i).get("address");
		}
		return data;
	}

	@DataProvider(name = "userDataFromExcel")
	public Object[][] getUserDataFromExcel() throws IOException {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/userData.xlsx";
		List<Map<String, String>> testData = ExcelReader.getTestData(filePath, "Sheet1");

		// Convert List<Map<String, String>> to Object[][] for DataProvider
		Object[][] data = new Object[testData.size()][1];
		for (int i = 0; i < testData.size(); i++) {
			data[i][0] = testData.get(i);
		}
		return data;
	}

	@Test(dataProvider = "userDataFromExcel")
	public void validateCreateUserFromExcel(Map<String, String> userData) {

		// Create request payload
		String payload = "{ \"name\": \"" + userData.get("Name") + "\", " + "\"email\": \"" + userData.get("Email")
				+ "\", " + "\"address\": \"" + userData.get("Address") + "\" }";

		// Send POST request
		Response response = given().baseUri("https://jsonplaceholder.typicode.com")
				.header("Content-Type", "application/json").body(payload).when().post("/users");

		// Log the response

		// Validate status code
		response.then().statusCode(201);

		// Validate response body
		response.then().body("name", equalTo(userData.get("Name")));
		response.then().body("email", equalTo(userData.get("Email")));
		response.then().body("address", equalTo(userData.get("Address")));

	}

	@Test(dataProvider = "userDataFromJson")
	public void validateCreateUserFromJson(String name, String email, String address) {

		// Create request payload
		String payload = "{ \"name\": \"" + name + "\", \"email\": \"" + email + "\", \"address\": \"" + address
				+ "\" }";

		// Send POST request
		Response response = given().baseUri("https://jsonplaceholder.typicode.com")
				.header("Content-Type", "application/json").body(payload).when().post("/users");

		// Log the response

		// Validate status code
		response.then().statusCode(201);

		// Validate response body
		response.then().body("name", equalTo(name));
		response.then().body("email", equalTo(email));
		response.then().body("address", equalTo(address));

	}

	@Test(dataProvider = "userData")
	public void validateCreateUser(String name, String email, String address) {
//        extentTest = ExtentReportManager.createTest("Validate Create User", "Validates the POST /users API");

		// Create request payload
		String payload = "{ \"name\": \"" + name + "\", \"email\": \"" + email + "\", \"address\": \"" + address
				+ "\" }";
//        extentTest.info("Request Payload: " + payload);

		// Send POST request
		Response response = given().baseUri("https://jsonplaceholder.typicode.com")
				.header("Content-Type", "application/json").body(payload).when().post("/users");

		// Log the response
//        extentTest.info("Response: " + response.asPrettyString());

		// Validate status code
		response.then().statusCode(201);
//        extentTest.pass("Status code is 201");

		// Validate response body
		response.then().body("name", equalTo(name));
		response.then().body("email", equalTo(email));
		response.then().body("address", equalTo(address));
//        extentTest.pass("Response body validated successfully");
	}
}
