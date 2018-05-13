package customlistener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testbase.TestBase;

public class Listener extends TestBase implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()) {
			String Userdirectory=System.getProperty("user.dir");
			String Customname="//src//test//java//screenshots//";
			String FailureImageFileName=Userdirectory+Customname+new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())+"-"+result.getMethod().getMethodName()+".png";
			File srcfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         try {
			FileUtils.copyFile(srcfile, new File(FailureImageFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Reporter.log("a <href=\""+FailureImageFileName+"\"><img src=\"file:///" +FailureImageFileName+ "\" alt=\"\""+ "height='100' width='100'/>" + "<br\\>" );
         Reporter.setCurrentTestResult(null);
         Reporter.log(result.getName()+ "Test Method Failed\n");
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
	
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
