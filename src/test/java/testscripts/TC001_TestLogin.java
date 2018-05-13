package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagelibrary.SignIn;
import testbase.TestBase;

public class TC001_TestLogin extends TestBase{
   SignIn signin;
   
   @BeforeClass
   public void OpenBrowser() throws IOException {
	   init();
   }
   
   @Test
   public void TestLogin() {
	   signin = new SignIn(driver);
	   signin.ClickonSigninlink();
	   signin.VerifySigninPage();
	   signin.EnterEmailID("subhranshup87@gmail.com");
	   signin.EnterPassword("12345");
	   signin.ClickonSigninbutton();
	   //signin.VerifyLogin();
	   boolean isSuccess = signin.VerifyLogin();
	   if(isSuccess) {
		   Assert.assertTrue(true,"Login is pass");
	   }
		   else {
			   Assert.assertTrue(false,"Login is failed");
		   }
	   }

   
   @AfterClass
   public void QuitBrowser() {
	   CloseBrowser();
   }
}
