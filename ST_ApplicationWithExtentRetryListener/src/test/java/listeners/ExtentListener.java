package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.BaseTest;
import utils.ExtentReportNG;

public class ExtentListener extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentReportNG.getReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
	    test = extent.createTest(result.getMethod().getMethodName());
	    extentTest.set(test);
	  }

	 public void onTestSuccess(ITestResult result) {
		 extentTest.get().log(Status.PASS, "Test Pass Successfully");
	  }

	  
	  public void onTestFailure(ITestResult result) {
		  extentTest.get().fail(result.getThrowable());
		  try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	  }

	  
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	  
	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }


}
