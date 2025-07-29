package restassured.gorestapi.extentlistner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import restassured.gorestapi.util.ExtentManager;



public class ExtentTestListners implements ITestListener {

	 private static ExtentReports extentReports = ExtentManager.getInstance();
	 private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	 
	 @Override
	 public void onTestStart(ITestResult result) {
	     System.out.println(">>> onTestStart() called for: " + result.getMethod().getMethodName());
	     ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
	     test.set(extentTest);
	 }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().fail(result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().skip(result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	extentReports.flush();
	    }

	    public static ExtentTest getTest() {
	        return test.get();
	    }
}
