package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import utils.ExtentReportManager;

public class BaseTest {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        // Set base URI from config properties
        RestAssured.baseURI = ConfigManager.getProperty("base.url");

        // Set connection and socket timeouts dynamically
        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", ConfigManager.getIntProperty("timeout"))
                        .setParam("http.socket.timeout", ConfigManager.getIntProperty("timeout")));

        // Initialize RequestSpecification with common configurations
        requestSpec = RestAssured.given()
                .config(config)
                .log().all();  // Log all request details
    }
    
    @AfterSuite
    public void tearDownExtentReport() {
        ExtentReportManager.getInstance().flush();
    }
}
