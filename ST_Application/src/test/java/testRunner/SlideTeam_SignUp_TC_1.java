package testRunner;

import org.testng.annotations.Test;

import pageObjects.SlideTeamHomePageObjects;
import pageObjects.SlideTeamPricingPageObjects;
import pageObjects.SlideTeamSignUpPageObjects;
import utils.BaseTest;

public class SlideTeam_SignUp_TC_1 extends BaseTest{
	
	SlideTeamHomePageObjects slideTeamHomePageObjects;
	SlideTeamSignUpPageObjects slideTeamSignUpPageObjects;
	SlideTeamPricingPageObjects slideTeamPricingPageObjects;
	
	@Test
	public void ST_SignUp_TC_1() {
		slideTeamHomePageObjects = new SlideTeamHomePageObjects(driver);
		slideTeamHomePageObjects.clickOnSignUpButton();
		slideTeamSignUpPageObjects = new SlideTeamSignUpPageObjects(driver, prop);
		slideTeamSignUpPageObjects.verifySignPageContent();
		slideTeamSignUpPageObjects.enterSignUpDetails();
		slideTeamSignUpPageObjects.clickOnSignUpButton();
		slideTeamPricingPageObjects = new SlideTeamPricingPageObjects(driver);
		slideTeamPricingPageObjects.verifySuccessfulRegistrationMessage();
	}

}
