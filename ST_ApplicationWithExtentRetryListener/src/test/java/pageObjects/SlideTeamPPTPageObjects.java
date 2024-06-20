package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.BaseTest;


public class SlideTeamPPTPageObjects extends BaseTest{
	
	WebDriver driver;
	
	By pptMainTitle = By.xpath("//h1[@class='product-gallery-title']");
	By starRating = By.xpath("//div[contains(@class,'scroll-to-review')]");
	By downloadButton = By.xpath("//button[text()='Download this presentation']");
	By favouriteIcon = By.xpath("//img[contains(@class,'hover-img')]");
	By summerPopUp = By.xpath("//button[contains(@class,'close-popup')]");
	By myAccountLink = By.linkText("My Account");
	By recentlyViewed = By.linkText("Recently Viewed");
	

    public SlideTeamPPTPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyPPTTitle() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	driver.findElement(starRating).isDisplayed();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(pptMainTitle));
        Assert.assertEquals(driver.findElement(pptMainTitle).getText(), "Business Kpi Dashboard Showing Average Revenue And Clv");
    }
    
    public void clickOnDownloadButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
    	driver.findElement(downloadButton).click();
    	driver.findElement(favouriteIcon).isEnabled();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(summerPopUp));
    	driver.findElement(summerPopUp).click();
    }
    
    public void clickOnMyAccountLink() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	driver.findElement(recentlyViewed).isDisplayed();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountLink));
    	driver.findElement(myAccountLink).isEnabled();
    	wait.until(ExpectedConditions.elementToBeClickable(myAccountLink));
    	driver.findElement(myAccountLink).click();
//    	WebElement ele = driver.findElement(myAccountLink);
//    	JavascriptExecutor js = (JavascriptExecutor)driver;
//    	js.executeScript("arguments[0].click();", ele);
    }
    
}
