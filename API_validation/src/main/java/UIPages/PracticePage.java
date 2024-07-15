package UIPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePage {

	public WebDriver driver;

	public WebDriver getChromeDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\ApiValidationBDD\\API_validation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

	}
	
	public WebDriver getFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;

	}

	public void openUrl()
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");		
		
	}

	public void tearDown()
	{
		driver.quit();
	}

}
