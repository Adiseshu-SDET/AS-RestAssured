package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static int testCounter = 0;  // Counter to track the number of tests executed

    // Method to initialize Extent Reports
    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/extent-report.html";
            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("API Automation Report");
            sparkReporter.config().setReportName("REST Assured API Test Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Add environment details
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("JDK Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Test Framework", "TestNG");
            extent.setSystemInfo("Automation Tool", "REST Assured");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String description) {
        testCounter++;  // Increment counter whenever a new test is created
        return getInstance().createTest(testName, description);
    }

    public static int getTestCounter() {
        return testCounter;
    }
}
