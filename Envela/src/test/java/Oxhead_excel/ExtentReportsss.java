package Oxhead_excel;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static org.testng.Assert.fail;

import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.SkipException;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.configuration.ChartLocation;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	 
	public class ExtentReportsss {
		
		
		ExtentHtmlReporter htmlReporter ;
		 ExtentReports extent;
	        
	    ExtentTest test;
	    
	   

		
	    @BeforeTest
	    public void startReport() {
	    	// initialize the HtmlReporter
	    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
	        
	    	htmlReporter.config().setDocumentTitle("Oxhead_Excel report");//title of the report
	    	htmlReporter.config().setReportName("Functional report");//name of the report
	    	htmlReporter.config().setTheme(Theme.DARK);//set them
	    	
	    	extent=new ExtentReports();
	    	extent.attachReporter(htmlReporter);
	    	extent.setSystemInfo("Hostname", "localhost");
	    	extent.setSystemInfo("OS", "Windows10");
	    	
	        
	    }
	     
	    @Test
	    public void testCase1() {
	        test = extent.createTest("jhgfrtfghj");
	        Assert.assertTrue(true);
	        System.out.println("test1 passed");
	    }
	    
	    @Test(enabled = false)
	    public void testCase2() {
	        test = extent.createTest("Test Case 2", "PASSED test case");
	        Assert.assertTrue(true);
	    }
//	    
//	    @Test
//	    public void testCase3() {
//	        test = extent.createTest("Test Case 3", "PASSED test case");
//	        Assert.assertTrue(true);
//	    }
//	     
//	    @Test
//	    public void testCase4() {
//	        test = extent.createTest("Test Case 4", "PASSED test case");
//	        Assert.assertTrue(false);
//	    }
//	     
//	    @Test
//	    public void testCase5() {
//	        test = extent.createTest("Test Case 5", "SKIPPED test case");
//	        throw new SkipException("Skipping this test with exception");
//	    }
//	    
//	    @Test(enabled=false)
//		public void testCase6(){
//				test = extent.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
//			}
	   
	    @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	           // test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	        	// test.fail(result.getThrowable());
	        	 
	        	test.log(Status.FAIL," FAILED IS"+result.getName());
	        	test.log(Status.FAIL," FAILED IS"+result.getThrowable());
	           
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	           // test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	            
	            test.log(Status.PASS," PASSED IS"+result.getName());
	        }
	        else {
	           // test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            //test.skip(result.getThrowable());
	            
	            test.log(Status.SKIP," SKIPPED IS"+result.getName());
	        }
	    }
	     
	    @AfterTest
	    public void tearDown() {
	        extent.flush();
	    }
	}
	
	
	 

