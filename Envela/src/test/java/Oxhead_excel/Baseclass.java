package Oxhead_excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass extends LocatersClass {
	WebDriver dr;
	ExtentHtmlReporter htmlReporter ;
	ExtentReports extent;
	ExtentTest test;
	String DataPath="C:\\Users\\BalarajuGone\\Balaraju\\Eclipse-Workspace\\Envela\\Data\\Data1.xlsx";
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/oxheadtestReport.html");
		htmlReporter.config().setDocumentTitle("Oxhead_excel report");//title of the report
		htmlReporter.config().setReportName("Functional report");//name of the report
		htmlReporter.config().setTheme(Theme.DARK);//set them
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "Windows10");
	}	
	@BeforeMethod 
//			@Parameters({"bwr","url"})
//			public void setUp(String brw,String url ) throws InterruptedException {
//				if(brw.equalsIgnoreCase("chrome")) {
//					WebDriverManager.chromedriver().setup();
//					dr=new ChromeDriver();
//				}
//				if(brw.equalsIgnoreCase("edge")) {
//					Thread.sleep(5000);
//					WebDriverManager.edgedriver().setup();
//					dr=new EdgeDriver();
//				}
//				if(brw.equalsIgnoreCase("firefox")) {
//					WebDriverManager.firefoxdriver().setup();
//					dr=new FirefoxDriver();
//				}
//				dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//				dr.manage().window().maximize();
//				if(url.contains("http")) {
//					dr.get(url);
//				}
//				else {
//					System.out.println("Your url is incorrect");
//				}
//			}


	public void setUp() throws IOException{
		WebDriverManager.chromedriver().setup();
		dr=new ChromeDriver();	
		dr.manage().window().maximize();
		
		DataClass2 dc=new DataClass2(DataPath);
		dr.get(dc.data("url",1,0));
		
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL," FAILED IS  "+result.getName());
			test.log(Status.FAIL," FAILED IS  "+result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS," PASSED IS  "+result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			//test.log(Status.SKIP," SKIPPED IS  "+result.getName());
			test.skip(result.getThrowable());
		}
		dr.quit();
	}
	@AfterTest
	public void tearDown() {
		extent.flush();
	}

}
