package com.wipro.Selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.GooglePage;

public class GoogleTeste {

	WebDriver driver;
	
	@Before
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
//	@Test
//	public void testGoogle() {
//		GooglePage page = new GooglePage(driver);
//		page.acessGoogle().typeTextToSearch("The dogfather").clickSearchButton();
//		Assert.assertEquals("The Dogfather Brasil: A maior franquia de premium Hot dogs do Brasil", page.getResult())
	
	@Test
	public void testListaDog() {		
		GooglePage page = new GooglePage(driver);
		page.dogFather();
		String compardor = "17 cm R$ 12,90";
		assertEquals(compardor, page.getTtestList(compardor));
	}
	
	
	@After
	public void after() {
		driver.quit();			
	}	
	
}
