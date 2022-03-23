package Oxhead_excel;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("Success  ");

	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("Failure  ");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("Skipped  ");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("start  ");
	}



}
