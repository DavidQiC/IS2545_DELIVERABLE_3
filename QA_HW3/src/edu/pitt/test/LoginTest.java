package edu.pitt.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class LoginTest {
	private WebDriver driver;
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com/products-page/your-account/");
	}
	
	@After
	public void close(){
		driver.quit();
	}
	
	/**
	 * Login in without inputing username and password
	 * It should return error;
	 */
	@Test
	public void loginTest1_emptyInfo(){
		WebElement submit = driver.findElement(By.id("login"));
		submit.submit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id='ajax_loginform']/p[1]"));
		assertEquals("Please enter your username and password.", msg.getText());
	}
	
	/**
	 * Login in with inputing correct username and incorrect password
	 * It should return error;
	 */
	@Test
	public void loginTest2_errorUserName(){
		WebElement logBox = driver.findElement(By.id("log"));
		logBox.sendKeys("123");
		WebElement pwdBox = driver.findElement(By.id("pwd"));
		pwdBox.sendKeys("123");
		WebElement submit = driver.findElement(By.id("login"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/strong[1]"));
		assertEquals("ERROR", msg.getText());
	}
	
	/**
	 * Login in with inputing incorrect username and incorrect password
	 * It should return error;
	 */
	@Test
	public void loginTest3_errorPassword(){
		WebElement logBox = driver.findElement(By.id("log"));
		logBox.sendKeys("qic921015");
		WebElement pwdBox = driver.findElement(By.id("pwd"));
		pwdBox.sendKeys("12311");
		WebElement submit = driver.findElement(By.id("login"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/strong[1]"));
		assertEquals("ERROR", msg.getText());
	}
}
