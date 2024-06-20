package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.BaseTest;


public class SlideTeamFreePPTListingPageObjects extends BaseTest{
	
	WebDriver driver;
	
	By categoryTitle = By.xpath("//h1[@class='custom-category-title']");
	By pptTitle = By.xpath("//strong[@rel='imgtip[127795]']");
	

    public SlideTeamFreePPTListingPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyFreePPTListingPageTitle() {
        Assert.assertEquals(driver.findElement(categoryTitle).getText(), "Free Business PowerPoint Templates, Backgrounds, Slides and Maps");
    }
    
    public void clickOnPPT() {
    	driver.findElement(pptTitle).click();
    }
    
    public void windowHandle() {
    	Set <String> windowHandles = driver.getWindowHandles();
    	Iterator <String> itr = windowHandles.iterator();
    	String parentWindow = itr.next();
    	String childWindow = itr.next();
    	driver.switchTo().window(childWindow);
    }

}
