package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static Properties Repositories = new Properties();
	public File f;
	public FileInputStream FI;
	public WebDriver driver;
	
	/**
	 * Get the values from Properties File 
	 * @throws IOException
	 */
	
	public void init() throws IOException {
		loadPropertiesFile();
		selectBrowser(Repositories.getProperty("Browser"));
		driver.get(Repositories.getProperty("URL"));
	}
	
	/**
	 * Launching the Browser
	 * @param Browser
	 * @return
	 */
	
	public WebDriver selectBrowser(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\target\\"+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		}else if(Browser.equalsIgnoreCase("Firfox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\target\\"+"geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
		
	}

	public void loadPropertiesFile() throws IOException {
		f =new File("E:\\Satish_Maven\\Maven_Workspace\\TestApplication\\src\\test\\java\\config\\Config.properties");
		FI=new FileInputStream(f);
		Repositories.load(FI);
	}
	
	public void explicitWait(WebElement element,int timeToWaitInSecond) {
		WebDriverWait wait= new WebDriverWait(driver, timeToWaitInSecond);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void CloseBrowser() {
		driver.close();
	}

}
