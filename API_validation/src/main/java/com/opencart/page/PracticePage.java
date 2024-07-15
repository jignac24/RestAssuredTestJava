package com.opencart.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticePage {

	public WebDriver driver;

	public WebDriver getDriver() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\ApiValidationBDD\\API_validation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
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
