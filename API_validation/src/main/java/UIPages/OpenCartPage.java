package UIPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartPage {
	public WebDriver driver;

	public WebDriver getDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\ApiValidationBDD\\API_validation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;

	}

	public void openUrl() {
		driver.get("https://naveenautomationlabs.com/opencart/");
	}

	public WebElement getMenu(String name) {

		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='" + name + "']"));
		return element;
	}

	public void closeBrowser() {
		driver.quit();
	}

}
