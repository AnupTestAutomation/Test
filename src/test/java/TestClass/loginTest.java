package TestClass;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.BaseClass.Base_Test;
import com.Constants.AppConstants;

public class loginTest extends Base_Test {


	@Test(priority=1)
	public void verifyLoginTest() {

		try {
			login.enterCredentials();
			Reporter.log("Username and Password enter successfully",true);

			login.clickOnMenuButton();
			Reporter.log("Successfully clicks on Menu Button",true);

			login.clickBrowserBack();
			Reporter.log("Successfully perform browser Back",true);

			login.clickOnAddToCartBtn();
			Reporter.log("Successfully clicks on Add To Cart Button",true);

			String productsText=login.getPageHeader();
			Reporter.log("The Header name is :"+productsText,true);

			Assert.assertEquals(productsText, AppConstants.products_PageHeader,"Header is not Matching");
			Reporter.log("Header is Matched and Verified Successfully",true);

			login.clickOnCartButton();
			Reporter.log("Successfully clicks On Cart Button",true);
			
			String yourCartText=login.getYourCartText();
			Reporter.log("The your cart page text is :"+yourCartText,true);
			
			Assert.assertEquals(yourCartText, AppConstants.YourCart_PageHeader,"your cart page text is not Matching");
			Reporter.log("Your Cart Page Header Text is Matched and Verified Successfully",true);
			
			login.clickOnCheckoutButton();
			Reporter.log("Successfully clicks On Checkout Button",true);
			
			
			String yourInformationText=login.getYourInformation();
			Reporter.log("The your cart page text is :"+yourInformationText,true);
			
			Assert.assertEquals(yourInformationText, AppConstants.YourInformation_PageHeader,"Checkout: Your Information page text is not Matching");
			Reporter.log("Checkout: Your Information Page Header Text is Matched and Verified Successfully",true);
		
			login.enterDetails();
			Reporter.log("Successfully Enters Details and submit",true);

			String OverviewPageText=login.getOverviewText();
			Reporter.log("The your cart page text is :"+OverviewPageText,true);
			
			Assert.assertEquals(OverviewPageText, AppConstants.Overview_PageHeader,"Checkout: Overview page text is not Matching");
			Reporter.log("Checkout: Overview Page Header Text is Matched and Verified Successfully",true);
		
			String totalPriceText=login.getTotalPriceText();
			Reporter.log("The Total Price Text is :"+totalPriceText,true);
			
		}catch(Exception e) {
			Reporter.log("Wrong operation performed",true);
		}
	}
}
