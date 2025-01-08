package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    @Test
    public void verifyGetUsers() {
        // Send GET request and capture the response
        Response response = requestSpec.get("/users");

        // Log response details
        response.then().log().all();

        // Validate response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

        // Validate response content type
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8", "Content type mismatch");
    }
}
