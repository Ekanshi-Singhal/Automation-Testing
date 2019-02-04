package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("the ailed tests are : " + result.getName() + result.getEndMillis());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Listener is invoked here! the skipped tests are : " + result.getTestName() + " in time " + result.getEndMillis());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("the testcase details on start are" + context.getClass());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("the testcase details on finish are" + context.getClass());
	}

}
