package testscripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagelibrary.CreateAnAccount;
import pagelibrary.SignIn;
import testbase.TestBase;

public class TC002_CreateAccount extends TestBase{
	
	CreateAnAccount CreateAccount;
	SignIn signin;
	
	
	//launch Browser
	@BeforeClass
	   public void OpenBrowser() throws IOException {
		   init();
	   }
	@Test
	   public void CreateAccount() throws InterruptedException {
		signin = new SignIn(driver);
		CreateAccount= new CreateAnAccount(driver);
		signin.ClickonSigninlink();
		signin.VerifySigninPage();
		CreateAccount.EnterEmaiId("subhra@gmail.com");
		CreateAccount.ClickOnAccount();
		Thread.sleep(3000);
		CreateAccount.VerifyAccountLabel();
		CreateAccount.EnterFirstName("Subhranshu");
		CreateAccount.EnterLastName("Pani");
		CreateAccount.SelectDay("10");
		CreateAccount.SelectMonth(11);
		
	   }
	
	@AfterClass
	   public void QuitBrowser() {
		   CloseBrowser();
	   }
	   

}
