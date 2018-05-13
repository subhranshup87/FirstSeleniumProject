package pagelibrary;

import static org.testng.Assert.assertEquals;

import java.util.logging.Logger;

import org.apache.logging.log4j.core.util.Assert;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;




public class SignIn {

	WebDriver driver;
	static Logger log=Logger.getLogger(SignIn.class.getName());
	By signin=By.xpath("//a[@class='login']");
	By emailid=By.xpath("//input[@id='email']");
	By password=By.xpath("//input[@id='passwd']");
	By signinbtn=By.xpath("//button[@id='SubmitLogin']");
	By VerifySigninPage=By.xpath("//h[@class='page-heading']");
	By VerifyLoginPage=By.xpath("//h1[@class='page-heading']");
	
	public SignIn(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * This method will click on Sign In Link of HomePage
	 */
	public void ClickonSigninlink() {
		log.info("Clicking in Sign In Link");
		driver.findElement(signin).click();
	}
	
	public void EnterEmailID(String EmailID) {
		log.info("Entering Email ID");
		driver.findElement(emailid).sendKeys(EmailID);
	}
	
	public void EnterPassword(String Password) {
		log.info("Entering Password");
		driver.findElement(password).sendKeys(Password);
	}
	
	public void ClickonSigninbutton() {
		log.info("Clicking in Sign In Button");
		driver.findElement(signinbtn).click();
	}
	
	public boolean VerifySigninPage() {
		log.info("Verify Signin page dispalyed or not");
		try {
		driver.findElement(VerifySigninPage).isDisplayed();
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean VerifyLogin() {
		log.info("Verify Login Successful or not");
		String Actual=driver.findElement(VerifyLoginPage).getText();
		assertEquals(Actual, "MY ACCOUNT");
		return true;
		
	}
}
