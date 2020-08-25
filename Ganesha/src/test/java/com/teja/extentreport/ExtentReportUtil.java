package com.teja.extentreport;

import org.testng.annotations.BeforeTest;

public class ExtentReportUtil {
	
	public ExtentReports extent;



	@BeforeTest
	public void config(){

	// ExtentReports , ExtentSparkReporter

	String path =System.getProperty("user.dir")+"\\reports\\index.html";

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	reporter.config().setReportName("Web Automation Results");

	reporter.config().setDocumentTitle("Test Results");

	extent =new ExtentReports();

	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "Rahul Shetty");

	}

	@Test

	public void initialDemo()

	{

	ExtentTest test= extent.createTest("Initial Demo");

	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

	WebDriver driver =new ChromeDriver();

	driver.get("https://rahulshettyacademy.com");

	System.out.println(driver.getTitle());

	driver.close();

	//test.fail("Result do not match");

	extent.flush();

	}

}
