package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkreporter; //UI of the report
	public ExtentReports reports; //adding information in the report
	public ExtentTest test;//create test entries and update status of the method in the report
	String reportname;
	public void onStart(ITestContext context) 
	{
		//report name and timestamp for seperate report	
		String reporttimestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		reportname = "Test_report_"+reporttimestamp+".html";
		
		//report location and UI of the report is configured 
		sparkreporter = new ExtentSparkReporter(".\\reports\\"+reportname);
		sparkreporter.config().setDocumentTitle("Automation report");
		sparkreporter.config().setReportName("Functional testing report");
		sparkreporter.config().setTheme(Theme.DARK);
		
		//adding info in the report
		reports = new ExtentReports();
		reports.attachReporter(sparkreporter); //attaching UI to the report to be created
		reports.setSystemInfo("Application", "OpenCart");
		reports.setSystemInfo("Computer name", "DELL");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Tester",System.getProperty("user.name"));
		
		String os = context.getCurrentXmlTest().getParameter("os");
		reports.setSystemInfo("os", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("browser", browser);
		
		List<String> includedgroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedgroups.isEmpty())
		{
			reports.setSystemInfo("groups", includedgroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test is passed"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test is failed "+result.getName());
		
		try
		{
			String imgpath = new BaseClass().capturescreenshot(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test is skipeed"+result.getName());
	}
	 
	public void onFinish(ITestContext context) 
	{
		reports.flush();
		
		//PIECE OF CODE TO AUTOMATICALLY OPEN REPORT IN BROWSER WINDOW AFTER TEST COMPLETION
		String pathOfExtentReport = System.getProperty("user.dir")+".\\reports\\"+reportname;
		File ExtentReport = new File(pathOfExtentReport);
		
		try
		{
			Desktop.getDesktop().browse(ExtentReport.toURI());
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}
}
