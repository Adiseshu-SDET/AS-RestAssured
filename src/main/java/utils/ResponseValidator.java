package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {

    /**
     * Validates the status code of the response.
     *
     * @param response     The API response
     * @param expectedCode The expected status code
     */
    public static void validateStatusCode(Response response, int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode, "Status code mismatch");
    }

    /**
     * Validates the content type of the response.
     *
     * @param response             The API response
     * @param expectedContentType  The expected content type
     */
    public static void validateContentType(Response response, String expectedContentType) {
        Assert.assertEquals(response.getContentType(), expectedContentType, "Content type mismatch");
    }

    /**
     * Validates a specific field in the response body.
     *
     * @param response     The API response
     * @param jsonPath     The JSON path of the field to validate
     * @param expectedValue The expected value of the field
     */
    public static void validateField(Response response, String jsonPath, Object expectedValue) {
        Assert.assertEquals(response.jsonPath().get(jsonPath), expectedValue, "Field value mismatch for: " + jsonPath);
    }
}
