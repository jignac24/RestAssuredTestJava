package testcases;

import org.testng.annotations.Test;

import UIPages.PracticePage;
import UIPages.UtilityPage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class TestWebTable {

	PracticePage page = new PracticePage();
	WebDriver driver = page.getChromeDriver();
	UtilityPage utility = new UtilityPage(driver);
	
	@BeforeTest
	public void beforeTest()
	{
		page.openUrl();
	}

	@Test
	public void test_dynamic_table()
	{
		WebElement table = driver.findElement(By.cssSelector("table[id=\"product\"]>tbody"));
		utility.scrolldown(table);
		
		List<WebElement> cols = driver.findElements(By.cssSelector("table[id=\"product\"]>tbody>tr>th"));
		List<WebElement> rows = driver.findElements(By.cssSelector("table[id=\"product\"]>tbody>tr>td"));
		System.out.println("Total Cols: "+ cols.size());
		System.out.println("Total Rows: "+ rows.size());
		
		for(WebElement row: rows)
		{						
			System.out.println(row.getText());
		}
	}

	@AfterTest
	public void afterTest()
	{
		page.tearDown();
	}

}
