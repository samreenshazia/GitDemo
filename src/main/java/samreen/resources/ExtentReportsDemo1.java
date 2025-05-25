package samreen.resources;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo1 {
	
	@Test
	public static ExtentReports  extentReportsmethod()
	{
		String path = System.getProperty("user.div") + "\\reports\\index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(path);
		rep.config().setReportName("Web Automation Reults");
		rep.config().setDocumentTitle("Reports page");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "samreen");
		return extent;
		
		
	}

}
