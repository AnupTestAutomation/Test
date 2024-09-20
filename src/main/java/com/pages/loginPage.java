package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Constants.AppConstants;
import com.Utils.ElementUtilities;

public class loginPage {

	private WebDriver driver;
	ElementUtilities util;

	private	By username=By.xpath("//input[@name='user-name']");
	private	By password=By.xpath("//input[@name='password']");
	private	By loginbtn=By.xpath("//input[@name='login-button']");
	private	By menubtn=By.xpath("//button[text()='Open Menu']");
	private	By about=By.xpath("//nav/a[text()='About']");
	private	By addToCart=By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	private	By productsPageText=By.xpath("//span[text()='Products']");
	private	By cartbtn=By.xpath("//a[@class='shopping_cart_link']");
	private	By yourCartText=By.xpath("//span[text()='Your Cart']");
	private	By checkoutBtn=By.xpath("//button[@name='checkout']");
	private	By yourInformationText=By.xpath("//span[text()='Checkout: Your Information']");
	private	By firstName=By.xpath("//input[@name='firstName']");
	private	By lastName=By.xpath("//input[@name='lastName']");
	private	By postalCode=By.xpath("//input[@name='postalCode']");
	private	By continueButton=By.xpath("//input[@id='continue']");	
	private	By overviewText=By.xpath("//span[text()='Checkout: Overview']");
	private	By totalPriceText=By.xpath("//div[@class='summary_info_label summary_total_label']");

	public loginPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtilities(driver);
	}
	
	public void enterCredentials() {
		util.dosendkeys(username,AppConstants.username);
		util.dosendkeys(password,AppConstants.password);
		util.waitForElementVisible(loginbtn);
		util.doClick(loginbtn);
	}
	
	public void clickOnMenuButton() {
		util.waitForElementVisible(menubtn);
		util.doClick(menubtn);
		
		util.waitForElementVisible(about);
		util.doActionClick(about);
	}
	
	public void clickBrowserBack() {
		util.browserBackward(about);
	}
	
	public void clickOnAddToCartBtn() {
		util.waitForElementVisible(addToCart);
		util.doActionClick(addToCart);
	}
	
	public String getPageHeader() {
	String pageText=util.getText(productsPageText);
	return pageText;
	}
	
	public void clickOnCartButton() {
		util.doClick(cartbtn);
	}
	
	public String getYourCartText() {
		String yourCartPageText=util.getText(yourCartText);
		return yourCartPageText;
		}
	
	public void clickOnCheckoutButton() {
		util.waitForElementVisible(checkoutBtn);
		util.doClick(checkoutBtn);
	}
	
	public String getYourInformation() {
		util.waitForElementVisible(yourInformationText);
		String YourInformationText=util.getText(yourInformationText);
		return YourInformationText;
		}
	
	public void enterDetails() {
		util.dosendkeys(firstName,AppConstants.first_Name);
		util.dosendkeys(lastName,AppConstants.last_Name);
		util.dosendkeys(postalCode,AppConstants.postal_Code);
		util.doClick(continueButton);
	}
	
	public String getOverviewText() {
		util.waitForElementVisible(overviewText);
		String OverviewPageText=util.getText(overviewText);
		return OverviewPageText;
		}
	
	public String getTotalPriceText() {
		String TotalPriceText=util.getText(totalPriceText);
		return TotalPriceText;
		}
}
