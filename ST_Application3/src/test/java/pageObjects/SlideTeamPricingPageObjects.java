package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.BaseTest;

public class SlideTeamPricingPageObjects extends BaseTest{
	
	WebDriver driver;
	
	By freeStuffLink = By.xpath("//li[contains(@class,'free-stuff')]/a");
	By freePPTLink = By.linkText("Free PPTs");
	By freeBusinessPPT = By.linkText("Free Business PPTs");
	By successfulRegistrationMessage = By.xpath("//span[@x-html='message.text']");
	
	By myAccountLink = By.xpath("//a[text()='My Account']");
	
	By monthlySubsPrice = By.xpath("//div[contains(@class,'slide-product slider-individual')]//div[1]//div[2]//span[1]//span[1]//em");
	By monthlyJoinNowButton = By.xpath("//div[@id='Individual']//div[contains(@class,'table-inner clearfix')]//div[1]//div[3]//span[1]//form[1]//button[1]//span[1]");

    public SlideTeamPricingPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyPricingPageTitle() {
        Assert.assertEquals(driver.getTitle(), "Pricing");
    }
    
    public void clickOnMyAccount() {
        driver.findElement(myAccountLink).click();
    }
    
    public void clickOnFreeBusinessPPTLink() {
    	WebElement freeStuff = driver.findElement(freeStuffLink);
    	Actions action = new Actions(driver);
    	action.moveToElement(freeStuff).perform();
    	driver.findElement(freePPTLink).isDisplayed();
    	driver.findElement(freeBusinessPPT).isDisplayed();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(freeBusinessPPT));
    	driver.findElement(freeBusinessPPT).click();
    }
    
    public void verifySuccessfulRegistrationMessage() {
    	String expSuccessfulConfMessage = driver.findElement(successfulRegistrationMessage).getText();
    	String actSuccessfulConfMessage = "Thank you for registering with SlideTeam. You must have subscription to download the product.";
    	Assert.assertEquals(actSuccessfulConfMessage, expSuccessfulConfMessage);
    }
    
    public String getMonthlySubsPrice() {
    	return driver.findElement(monthlySubsPrice).getText();
    }
    
    public void clickOnMonthlyJoinNowButton() {
    	driver.findElement(monthlyJoinNowButton).click();
    }

}
