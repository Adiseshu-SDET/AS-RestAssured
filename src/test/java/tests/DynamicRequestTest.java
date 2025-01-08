package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

public class DynamicRequestTest {

    @Test
    public void testGetUsersWithHeadersAndParams() {
        // Headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer sample_token");

        // Query parameters
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("page", "1");

        // Build and send GET request
        Response response = RequestBuilder.buildGetRequest(headers, queryParams)
                                          .get("https://jsonplaceholder.typicode.com/users");

        // Log response details
        response.then().log().all();

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        Assert.assertTrue(response.jsonPath().getList("").size() > 0, "No users found");
    }

    @Test
    public void testPostRequest() {
        // Headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer sample_token");

        // Request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "John Doe");
        requestBody.put("email", "john.doe@example.com");

        // Build and send POST request
		Response response = RequestBuilder.buildPostRequest(headers, null, requestBody)
                                          .post("https://jsonplaceholder.typicode.com/posts");

        // Log response details
        response.then().log().all();

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 201, "Status code is not 201");
        Assert.assertNotNull(response.jsonPath().get("id"), "ID is not present in the response");
    }
}
