package pagelibrary;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccount {

	WebDriver driver;
	static Logger log=Logger.getLogger(SignIn.class.getName());
	By CreateAccountEmail = By.xpath("//input[@id='email_create']");
	By CreateAccountButton = By.xpath("//button[@id='SubmitCreate']");
	By Gender1=By.xpath("//div[@id='uniform-id_gender1']");
	By FirstName=By.xpath("//input[@id='customer_firstname']");
	By LastName=By.xpath("//input[@id='customer_lastname']");
	By CreateAccountLabel = By.xpath("//h1[@class='page-heading']");
	By Days=By.xpath("//*[@id='days']");
	By Months=By.xpath("//*[@id='months']");
	By Years=By.xpath("//*[@id='years']");
	
	public CreateAnAccount(WebDriver driver) {
		this.driver=driver;
	}
	
	public Boolean VerifyAccountLabel() {
		log.info("Verify Create Account Label");
		try {
		driver.findElement(CreateAccountLabel).isDisplayed();
		return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void EnterEmaiId(String EmailId) {
		log.info("Entering the first name");
		driver.findElement(CreateAccountEmail).sendKeys(EmailId);
	}
	
	public void ClickOnAccount() {
		log.info("Clicking on Create An Account button");
		driver.findElement(CreateAccountButton).click();
	}
	
	public void EnterFirstName(String FirstName) {
		log.info("Entering the first name");
		driver.findElement(this.FirstName).sendKeys(FirstName);
	}
	
	public void EnterLastName(String LastName) {
		log.info("Entering the Last name");
		driver.findElement(this.LastName).sendKeys(LastName);
	}
	
	
	
	public void SelectDay(String Day) {
		log.info("Selecting Day from the Dropdown");
	
		Select drpDays = new Select(driver.findElement(Days));
		drpDays.selectByValue(Day);
	}
	
	public void SelectMonth(int Month) {
		log.info("Selecting Month from the Dropdown");
			Select drpMonths = new Select(driver.findElement(Months));
		drpMonths.selectByIndex(Month);
	}
}
