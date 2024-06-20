package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SlideTeamCheckoutPageObjects;
import pageObjects.SlideTeamFreePPTListingPageObjects;
import pageObjects.SlideTeamHomePageObjects;
import pageObjects.SlideTeamLoginPageObjects;
import pageObjects.SlideTeamMyAccountPageObjects;
import pageObjects.SlideTeamPPTPageObjects;
import pageObjects.SlideTeamPricingPageObjects;
import utils.BaseTest;

public class SlideTeam_Login_TC_2 extends BaseTest{

	SlideTeamHomePageObjects slideTeamHomePageObjects;
	SlideTeamLoginPageObjects slideTeamLoginPageObjects;
	SlideTeamPricingPageObjects slideTeamPricingPageObjects;
	SlideTeamFreePPTListingPageObjects slideTeamFreePPTListingPageObjects;
	SlideTeamPPTPageObjects slideTeamPPTPageObjects;
	SlideTeamMyAccountPageObjects slideTeamMyAccountPageObjects;
	SlideTeamCheckoutPageObjects slideTeamCheckoutPageObjects;
	String monthlyPrice;
	String paymentInfoPrice;
	String orderReviewPrice;
	
	
    @Test
    public void ST_TC_1() {
    	slideTeamHomePageObjects = new SlideTeamHomePageObjects(driver);
    	slideTeamHomePageObjects.verifyHomePageTitle();
    	slideTeamHomePageObjects.clickOnSignInButton();
    	slideTeamLoginPageObjects = new SlideTeamLoginPageObjects(driver, prop);
    	slideTeamLoginPageObjects.verifyLoginPageTitle();
    	slideTeamLoginPageObjects.enterLoginDetails();
    	slideTeamLoginPageObjects.clickOnLoginButton();
    	slideTeamPricingPageObjects = new SlideTeamPricingPageObjects(driver);
    	slideTeamPricingPageObjects.verifyPricingPageTitle();
    	monthlyPrice = slideTeamPricingPageObjects.getMonthlySubsPrice();
    	slideTeamPricingPageObjects.clickOnMonthlyJoinNowButton();
    	slideTeamCheckoutPageObjects = new SlideTeamCheckoutPageObjects(driver);
    	slideTeamCheckoutPageObjects.verifyCheckoutPageTitle();
    	paymentInfoPrice = slideTeamCheckoutPageObjects.verifyPaymentInfoPrice();
    	Assert.assertEquals(monthlyPrice, paymentInfoPrice);
    	orderReviewPrice = slideTeamCheckoutPageObjects.verifyOrderReviewPrice();
    	Assert.assertEquals(monthlyPrice, orderReviewPrice);
    	slideTeamCheckoutPageObjects.clickOnSecureCheckoutButton();
    }

}
