/*package samreen.testcomponents;

import org.testng.ITestListener;


	import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import samreen.resources.ExtentReportsDemo1;

import java.io.IOException;

import org.testng.ITestContext;

	public class Listeners extends BaseTest implements ITestListener {
		ExtentTest test;
		ExtentReports extent = ExtentReportsDemo1.extentReportsmethod();
		
		 @Override
		    public void onStart(ITestContext result) {
		    	test = extent.createTest(((ITestResult) result).getMethod().getMethodName());
		    } 
		 
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.log(Status.PASS, "Passed");
	 
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	test.fail(result.getThrowable());
	    	String path = null;
			try {
				 path = getScreenshot(result.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	    	
	        
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	       test.log(Status.SKIP, "skipped");
	    }

	   

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}
	*/
