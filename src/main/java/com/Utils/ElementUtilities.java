package com.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Constants.AppConstants;

public class ElementUtilities {

	private WebDriver driver;
	private Actions act;
	
	public ElementUtilities(WebDriver driver) {
		
		this.driver=driver;
		act=new Actions(driver);
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public void dosendkeys(By locator,String value) {
		WebElement ele=getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void doClick(By locator) {
		WebElement ele=getElement(locator);
		ele.click();
	}
	
	public void doActionClick(By locator) {
		act.click(getElement(locator)).perform();
	}
	
	public WebElement waitForElementVisible(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(AppConstants.timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public String getPageUrl() {
		String URL=driver.getCurrentUrl();
		return URL;
	}
	
	public void browserBackward(By locator) {
		driver.navigate().back();
	}
	
	public String getText(By locator) {
		String text=getElement(locator).getText();
		return text;
	}
	
}
