package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extentTest.set(extent.createTest(context.getName()));
    }

    @Override
    public void onTestStart(ITestResult result) {
    	
    	System.out.println("Starting test: " + result.getMethod().getMethodName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());

        // Add categories (tags) based on groups
        if (result.getMethod().getGroups().length > 0) {
            for (String group : result.getMethod().getGroups()) {
                test.assignCategory(group);
            }
        }

        extentTest.set(test);
        test.log(Status.INFO, "Test case started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test case passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	extentTest.get().log(Status.FAIL, "Test case failed: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, result.getThrowable());

        // Log request and response details (example)
        if (result.getParameters() != null && result.getParameters().length > 0) {
            extentTest.get().info("Request Payload: " + result.getParameters()[0]);
        }

        // Simulate attaching a screenshot (replace this with actual screenshot path for UI automation)
        String screenshotPath = "path/to/screenshot.png"; // Placeholder path
        extentTest.get().addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test case skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("Flushing Extent Report...");
        extent.flush();
    }
}
