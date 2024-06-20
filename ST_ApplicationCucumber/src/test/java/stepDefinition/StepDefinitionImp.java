package stepDefinition;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SlideTeamHomePageObjects;
import pageObjects.SlideTeamLoginPageObjects;
import pageObjects.SlideTeamPricingPageObjects;
import utils.BaseTest;

public class StepDefinitionImp extends BaseTest{
	
	SlideTeamHomePageObjects slideTeamHomePageObjects;
	SlideTeamLoginPageObjects slideTeamLoginPageObjects;
	SlideTeamPricingPageObjects slideTeamPricingPageObjects;
	
	@Given("User is landed on the home page")
	public void User_is_landed_on_the_home_page() throws IOException
	{
		initializeDriver();
	}
	
	@Given("User in the Home Page of the Application")
	public void User_in_the_Home_Page_of_the_Application()
	{
		slideTeamHomePageObjects = new SlideTeamHomePageObjects(driver);
    	slideTeamHomePageObjects.verifyHomePageTitle();
	}
	
	@When("Clicks on login button")
	public void Clicks_on_login_button()
	{
		slideTeamHomePageObjects.clickOnSignInButton();
    	slideTeamLoginPageObjects = new SlideTeamLoginPageObjects(driver);
    	slideTeamLoginPageObjects.verifyLoginPageTitle();
	}
	
	@And("^Enters valid email (.+) and password (.+)$")
	public void Enters_valid_email_and_password(String email, String password)
	{
		slideTeamLoginPageObjects.enterLoginDetails(email, password);
    	slideTeamLoginPageObjects.clickOnLoginButton();
	}
	
	@Then("User navigates to pricing page")
	public void User_navigates_to_pricing_page()
	{
		slideTeamPricingPageObjects = new SlideTeamPricingPageObjects(driver);
    	slideTeamPricingPageObjects.verifyPricingPageTitle();
		tearDown();
	}

}
