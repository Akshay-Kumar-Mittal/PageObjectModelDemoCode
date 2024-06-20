package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SlideTeamFreePPTListingPageObjects;
import pageObjects.SlideTeamHomePageObjects;
import pageObjects.SlideTeamLoginPageObjects;
import pageObjects.SlideTeamMyAccountPageObjects;
import pageObjects.SlideTeamPPTPageObjects;
import pageObjects.SlideTeamPricingPageObjects;
import utils.BaseTest;
import utils.Retry;

public class SlideTeam_Login_TC_1 extends BaseTest{

	SlideTeamHomePageObjects slideTeamHomePageObjects;
	SlideTeamLoginPageObjects slideTeamLoginPageObjects;
	SlideTeamPricingPageObjects slideTeamPricingPageObjects;
	SlideTeamFreePPTListingPageObjects slideTeamFreePPTListingPageObjects;
	SlideTeamPPTPageObjects slideTeamPPTPageObjects;
	SlideTeamMyAccountPageObjects slideTeamMyAccountPageObjects;
	
	
    @Test(retryAnalyzer = Retry.class)
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
//    	slideTeamPricingPageObjects.clickOnMyAccount();
//    	slideTeamPricingPageObjects.clickOnFreeBusinessPPTLink();
//    	slideTeamFreePPTListingPageObjects = new SlideTeamFreePPTListingPageObjects(driver);
//    	slideTeamFreePPTListingPageObjects.verifyFreePPTListingPageTitle();
//    	slideTeamFreePPTListingPageObjects.clickOnPPT();
//    	slideTeamFreePPTListingPageObjects.windowHandle();
//    	slideTeamPPTPageObjects = new SlideTeamPPTPageObjects(driver);
//    	slideTeamPPTPageObjects.verifyPPTTitle();
//    	slideTeamPPTPageObjects.clickOnDownloadButton();
//    	slideTeamPPTPageObjects.clickOnMyAccountLink();
//    	slideTeamMyAccountPageObjects = new SlideTeamMyAccountPageObjects(driver);
//    	slideTeamMyAccountPageObjects.clickOnPowerpointDwonload();
//    	String downloadedPPTTitle = slideTeamMyAccountPageObjects.getDownloadedPPTTitle();
//    	Assert.assertEquals(expPPTTitle, downloadedPPTTitle);
//    	slideTeamMyAccountPageObjects.clickOnDeleteAccount();
    }

}
