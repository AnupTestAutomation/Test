package com.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Constants.AppConstants;
import com.pages.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Test {

	public WebDriver driver;
	public loginPage login;

	@BeforeTest
	public void setUp() {
				
		
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(AppConstants.Page_timeout));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		login=new loginPage(driver);

	}

	//@AfterTest
	public void tearDown() {

		driver.quit();
	}
}
