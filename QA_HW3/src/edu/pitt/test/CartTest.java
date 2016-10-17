package edu.pitt.test;

import static org.junit.Assert.assertTrue;

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

public class CartTest {
	private WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/");
		WebElement searchBox = driver.findElement(By.name("s"));
		searchBox.sendKeys("mouse");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement select = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div/div/div[3]/form/div/div[1]/span/input"));
		select.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement item = driver.findElement(By.xpath("//*[@id='fancy_notification_content']/a[1]"));
		item.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@After
	public void close() {
		driver.quit();
	}
	
	/**
	 * Given we have added a mouse into our cart
	 * when we click remove button, the cart should be empty
	 */
	@Test
	public void cancelCart(){
		WebElement remove = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[6]/form/input[4]"));
		remove.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement content = driver.findElement(By.xpath("//*[@id='post-29']/div"));
		assertEquals(content.getText(), "Oops, there is nothing in your cart.");
	}
	
	/**
	 * Given we have added a mouse into our cart
	 * when we add the quantity to 5, the total sub should be 750 ( = 150 * 5) 
	 */
	@Test
	public void makeQuntityFive(){
		WebElement quantity = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[1]"));
		quantity.clear();
		quantity.sendKeys("5");
		WebElement update = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[4]"));
		update.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement price = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[5]/span/span"));
		assertEquals("$750.00", price.getText());
	}
	
	

	/**
	 * Given we have added a mouse into our cart
	 * when we add the quantity to -1, the cart should be empty
	 */
	@Test
	public void makeQuntityInnormal(){
		WebElement quantity = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[1]"));
		quantity.clear();
		quantity.sendKeys("-1");
		WebElement update = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[3]/form/input[4]"));
		update.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement content = driver.findElement(By.xpath("//*[@id='post-29']/div"));
		assertEquals(content.getText(), "Oops, there is nothing in your cart.");
	}
}
