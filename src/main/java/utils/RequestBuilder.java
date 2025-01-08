package utils;

import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.Map;

public class RequestBuilder {

    /**
     * Builds a GET request with optional headers and query parameters.
     *
     * @param headers        Map of headers (can be null)
     * @param queryParams    Map of query parameters (can be null)
     * @return RequestSpecification
     */
    public static RequestSpecification buildGetRequest(Map<String, String> headers, Map<String, String> queryParams) {
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);

        if (headers != null) {
            request.headers(headers);
        }

        if (queryParams != null) {
            request.queryParams(queryParams);
        }

        return request;
    }

    /**
     * Builds a POST request with optional headers, query parameters, and a request body.
     *
     * @param headers        Map of headers (can be null)
     * @param queryParams    Map of query parameters (can be null)
     * @param body           Request body (can be null)
     * @return RequestSpecification
     */
    public static RequestSpecification buildPostRequest(Map<String, String> headers, Map<String, String> queryParams, Object body) {
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);

        if (headers != null) {
            request.headers(headers);
        }

        if (queryParams != null) {
            request.queryParams(queryParams);
        }

        if (body != null) {
            request.body(body);
        }

        return request;
    }
}
