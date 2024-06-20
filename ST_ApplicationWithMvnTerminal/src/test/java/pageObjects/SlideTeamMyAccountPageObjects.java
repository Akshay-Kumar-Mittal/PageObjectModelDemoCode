package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseTest;


public class SlideTeamMyAccountPageObjects extends BaseTest{
	
	WebDriver driver;

	By powerPointDownloadLink = By.linkText("PowerPoint Downloads");
	By downloadPPTTitle = By.xpath("//tr/td/a");
	By deleteAccountLink = By.linkText("Delete Account");
	

    public SlideTeamMyAccountPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnPowerpointDwonload() {
    	driver.findElement(powerPointDownloadLink).click();
    }
    
    public String getDownloadedPPTTitle() {
    	return driver.findElement(downloadPPTTitle).getText();
    }
    
    public void clickOnDeleteAccount() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(deleteAccountLink));
    	driver.findElement(deleteAccountLink).click();
    	driver.findElement(By.xpath("//div[@class='modal-dialog']"));
    	driver.findElement(By.xpath("//input[@value='option1']")).click();
    	driver.findElement(By.xpath("//button[@id='delete-final']")).click();
//    	driver.findElement(By.xpath("//button[contains(@class,'button_2')]")).click();
//    	System.out.println(driver.findElement(By.xpath("//span[@x-html='message.text']")).getText());
    }

}