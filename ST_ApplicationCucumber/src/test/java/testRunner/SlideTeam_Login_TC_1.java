package testRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.SlideTeamHomePageObjects;
import pageObjects.SlideTeamLoginPageObjects;
import pageObjects.SlideTeamPricingPageObjects;
import utils.BaseTest;

public class SlideTeam_Login_TC_1 extends BaseTest{

	SlideTeamHomePageObjects slideTeamHomePageObjects;
	SlideTeamLoginPageObjects slideTeamLoginPageObjects;
	SlideTeamPricingPageObjects slideTeamPricingPageObjects;
	
	
    @Test(dataProvider="data")
    public void ST_TC_1(String email, String password) {
    	slideTeamHomePageObjects = new SlideTeamHomePageObjects(driver);
    	slideTeamHomePageObjects.verifyHomePageTitle();
    	slideTeamHomePageObjects.clickOnSignInButton();
    	slideTeamLoginPageObjects = new SlideTeamLoginPageObjects(driver);
    	slideTeamLoginPageObjects.verifyLoginPageTitle();
    	slideTeamLoginPageObjects.enterLoginDetails(email, password);
    	slideTeamLoginPageObjects.clickOnLoginButton();
    	slideTeamPricingPageObjects = new SlideTeamPricingPageObjects(driver);
    	slideTeamPricingPageObjects.verifyPricingPageTitle();
    }
    
    @DataProvider(name ="data")
    public Object[][] getData()
    {
    	return new Object[][] {{"testuser27thapril@gmail.com", "123456"},{"testuhhhhser27thapril@gmail.com", "123456"}};
    }

}
