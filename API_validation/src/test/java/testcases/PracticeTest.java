package testcases;

import org.testng.annotations.Test;

import UIPages.PracticePage;
import UIPages.UtilityPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PracticeTest {

	PracticePage page = new PracticePage();
	// WebDriver driver = page.getDriver();
	static WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browserName) throws Exception{
		
		if (browserName.equalsIgnoreCase("firefox")) {
            driver = page.getFirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("chrome")) {
        	driver = page.getChromeDriver();
        }
        else {
            throw new Exception("Browser is not correct");
        }
		page.openUrl();
        driver.manage().window().maximize();
	}

	@Test
	public void verify_Title() {

		Assert.assertEquals(driver.getTitle(), "Practice Page");

	}

	@Test(enabled = false)
	public void verifyRadioBtn() throws InterruptedException {
		// Verify Radio buttons

		List<WebElement> elements = driver.findElements(By.cssSelector("input[name='radioButton']"));
		for (WebElement element : elements) {
			System.out.println(element.getAttribute("value"));
			element.click();

		}

	}

	@Test(enabled = false)
	public void verify_dropDown() {
		// Verify drop-down

		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropDown);
		select.selectByValue("option2");
		select.selectByIndex(1);
		select.selectByVisibleText("Option3");

	}
	
	@Test(enabled = false)
	public void verify_openTab() throws InterruptedException {

		System.out.println("Verify that new Tab is opened or not");

		driver.findElement(By.id("opentab")).click();

		// Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		// Switch to the newly opened tab
		driver.switchTo().window(tabs.get(1));

		// Get the title of the newly opened page
		String newTabTitle = driver.getTitle();
		System.out.println("Title of the new tab: " + newTabTitle);
		Thread.sleep(10000);
		
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	@Test
	public void verify_checkBox() {
		// Verify drop-down

		List<WebElement> elements = driver.findElements(By.cssSelector("input[type=checkbox]"));
		for (WebElement element : elements) {
			System.out.println(element.getAttribute("value"));
			element.click();
		}

	}

	@Test(enabled = false)
	public void verify_openWindow() throws InterruptedException
	{
		
		Thread.sleep(5000);
		System.out.println("Verify that new window is opened or not");

		driver.findElement(By.cssSelector("#openwindow")).click();
		
		for (String winHandle : driver.getWindowHandles())
		{
			
			String title = driver.switchTo().window(winHandle).getTitle();			
			if (title.contentEquals("QAClick Academy - A Testing Academy to Learn, Earn and Shine"))
			{
				System.out.println("This is new window");
				driver.close();
				
			}			

		}
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void verify_popUp() {
		driver.findElement(By.id("name")).sendKeys("testing");
		driver.findElement(By.id("alertbtn")).click();

		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert();
		alert.accept();

	}
	
	@Test(enabled = false)
	public void verify_textbox() throws InterruptedException
	{		

		driver.findElement(By.id("hide-textbox")).click();
		
		WebElement textbox = driver.findElement(By.id("displayed-text"));	// Find Textbox	
		
		UtilityPage page = new UtilityPage(driver);
		page.scrolldown(textbox);  // Scroll down page
		
		Assert.assertEquals(textbox.isDisplayed(), false); // Textbox should disable
		
		driver.findElement(By.id("show-textbox")).click();		
		Assert.assertEquals(textbox.isDisplayed(), true); // Textbox should enabled
		
		textbox.sendKeys("showing now");

	}
	
	@Test
	public void verify_moveElement() throws InterruptedException{
		
		Actions action = new Actions(driver);		
		WebElement box = driver.findElement(By.id("mousehover"));
		
		action.scrollToElement(box).build();
		action.moveToElement(box).perform();
		driver.findElement(By.cssSelector("a[href='#top']")).click();
		
		action.scrollToElement(box).perform();
		action.moveToElement(box).perform();
		driver.findElement(By.xpath("//a[normalize-space()='Reload']")).click();
	}

	@AfterTest
	public void afterTest()
	{
		page.tearDown();
	}

}
