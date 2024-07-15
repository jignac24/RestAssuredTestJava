package UIPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityPage
{
	WebDriver driver;
	
	public UtilityPage(WebDriver driver) {
		this.driver = driver;
	}
	public void scrolldown(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,175)", element);
	}	

}
