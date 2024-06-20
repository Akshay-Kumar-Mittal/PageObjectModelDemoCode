package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SlideTeamHomePageObjects {
	
	WebDriver driver;
	
	By pricingPageLink = By.linkText("Pricing");
	By popularPPtLink = By.linkText("Popular PPTs");
	By signInLink = By.linkText("Sign In");
	By signUpLink = By.linkText("Sign up");
	
	String actHomePaheTitle = "PowerPoint Templates | PowerPoint Slides Templates| PPT Themes Presentation";

    public SlideTeamHomePageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyHomePageTitle() {
    	String expHomePageTitle= driver.getTitle();
    	Assert.assertEquals(actHomePaheTitle, expHomePageTitle);
    }

    public void clickOnSignInButton() {
        driver.findElement(signInLink).click();
    }
    
    public void clickOnSignUpButton() {
    	driver.findElement(signUpLink).click();
    }

}
