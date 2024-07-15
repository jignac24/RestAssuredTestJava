package testcases;

import org.testng.annotations.Test;

import UIPages.OpenCartPage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OpenCartTest extends OpenCartPage {
	
  OpenCartPage page = new OpenCartPage();  // call the openCartPage
  WebDriver driver = page.getDriver();     // getDriver method will return web driver

  @BeforeTest
  public void beforeTest()
  {
	  page.openUrl();
  }
  
  @Test
  public void verify_title() 
  {
	// System.out.print(driver.getTitle());
	Assert.assertEquals(driver.getTitle(), "Your Store");

  }
  
  @Test
  public void verify_menuTitle() 
  {
	  List<WebElement> elements = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li/a"));
	  for(WebElement ele : elements) {
		  String eleText = ele.getAttribute("innerText");		  
		  boolean actualVal =  page.getMenu(eleText).isDisplayed();
		  System.out.println(eleText + " = " + actualVal);
		  Assert.assertEquals(actualVal, true);
	  }

  }  


  @AfterTest
  public void afterTest()
  {
	  page.closeBrowser();
  }

}
