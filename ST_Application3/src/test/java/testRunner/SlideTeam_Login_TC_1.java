package testRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
	
	
    @Test(dataProvider="data", groups={"Login"})
    public void ST_TC_1(HashMap<String, String> input) {
    	slideTeamHomePageObjects = new SlideTeamHomePageObjects(driver);
    	slideTeamHomePageObjects.verifyHomePageTitle();
    	slideTeamHomePageObjects.clickOnSignInButton();
    	slideTeamLoginPageObjects = new SlideTeamLoginPageObjects(driver);
    	slideTeamLoginPageObjects.verifyLoginPageTitle();
    	slideTeamLoginPageObjects.enterLoginDetails(input.get("email"), input.get("password"));
    	slideTeamLoginPageObjects.clickOnLoginButton();
    	slideTeamPricingPageObjects = new SlideTeamPricingPageObjects(driver);
    	slideTeamPricingPageObjects.verifyPricingPageTitle();
    }
    
    @DataProvider(name ="data")
    public Object[][] getData() throws IOException
    {
    	List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//testData//LoginDetails.json");
    	return new Object[][] {{data.get(0)},{data.get(1)}};
    }

}
