package com.teja.web;

import static org.testng.Assert.assertEquals;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Facebook {
	
	public WebDriver driver;
	public String filePath;
	public FileInputStream fis;
	public Properties props;
	public String baseUrl;
	public String pageTitle;
	public String expectedBasePageTitle;
	
	
	@BeforeTest
	public void setup() throws IOException {
		filePath = System.getProperty("user.dir") + "\\data\\web.properties";
		fis=new FileInputStream(filePath);
		props=new Properties();
		props.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\Teja\\push\\Selenium\\N\\cd\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl=props.getProperty("baseUrl");
		expectedBasePageTitle=props.getProperty("basePageTitle");
		
		
		
	}
	
	@Test
	public void test001_facebookTitle() {
		
		driver.get(baseUrl);
		pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle,expectedBasePageTitle,"Title is not Matching");
	
	}
	
	@Test
	public void test002_facebookLogin() {
		
		
	}
	
	@Test
	public void test003_facebookLogout() {
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
