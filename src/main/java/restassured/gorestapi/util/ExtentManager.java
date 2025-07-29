package restassured.gorestapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extentReports;
	
	public static ExtentReports getInstance() {
		if(extentReports == null) {
			String reportDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String path = System.getProperty("user.dir") + "/test-output/ExtentReport_"+ reportDate + ".html";
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
			extentSparkReporter.config().setReportName("API Regression Test");
			extentSparkReporter.config().setDocumentTitle("API Automation");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);
		}
		return extentReports;
	}
}
