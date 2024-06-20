package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.BaseTest;

public class SlideTeamLoginPageObjects extends BaseTest{
	
	WebDriver driver;
	Properties prop;
	
	By emailAddress = By.xpath("//input[@name='login[username]']");
	By password = By.xpath("//input[@name='login[password]']");
	By loginButton = By.id("send2");
	
	String actLoginPageTitle = "Customer Login";

    public SlideTeamLoginPageObjects(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }
    
    public void verifyLoginPageTitle() {
        String expLoginPageTitle = driver.getTitle();
        Assert.assertEquals(actLoginPageTitle, expLoginPageTitle);
    }
    
    public void enterLoginDetails() {
    	driver.findElement(emailAddress).sendKeys(prop.getProperty("emailAddress"));
    	driver.findElement(password).sendKeys(prop.getProperty("password"));
    }
    
    public void clickOnLoginButton() {
    	driver.findElement(loginButton).click();
    }

}
