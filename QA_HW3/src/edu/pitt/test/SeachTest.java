package edu.pitt.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class SeachTest {
	private WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/");
	}

	@After
	public void close() {
		driver.quit();
	}

	/**
	 * type "mouse" into search box Since the web page only contains one item
	 * whose name contains "mouse" This test will only get one result
	 */
	@Test
	public void searchTest1_OnlyOne() {
		WebElement searchBox = driver.findElement(By.name("s"));
		searchBox.sendKeys("mouse");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement select = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div"));
		List<WebElement> allOptions = select.findElements(By.className("grid_product_info"));
		for (WebElement option : allOptions) {
			WebElement item = option.findElement(By.tagName("a"));
			System.out.println(String.format("item: %s", item.getText()));
		}
		System.out.println("total number of result:\t" + allOptions.size());
		assertTrue(allOptions.size() == 1);
	}

	/**
	 * type any meaningless words into search box This test will only get zero
	 * result
	 */
	@Test
	public void searchTest2_Zero() {
		WebElement searchBox = driver.findElement(By.name("s"));
		searchBox.sendKeys("sajisjaisaj");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement select = null;
		select = driver.findElement(By.xpath("//*[@id='content']/p"));
		System.out.println(select.getText());
		assertEquals(select.getText(), "Sorry, but nothing matched your search criteria. Please try again with some different keywords.");
	}

	/**
	 * type "apple" into search box, This test will only get more than result,
	 * because we know there are many items about Apple
	 */
	@Test
	public void searchTest3_MoreThanOne() {
		WebElement searchBox = driver.findElement(By.name("s"));
		searchBox.sendKeys("Apple");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement select = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div"));
		List<WebElement> allOptions = select.findElements(By.className("grid_product_info"));
		for (WebElement option : allOptions) {
			WebElement item = option.findElement(By.tagName("a"));
			System.out.println(String.format("item: %s", item.getText()));
		}
		System.out.println("total number of result:" + allOptions.size());
		assertTrue(allOptions.size() > 0);
	}
}
