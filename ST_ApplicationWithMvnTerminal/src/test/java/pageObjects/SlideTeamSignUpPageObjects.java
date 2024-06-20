package pageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.BaseTest;
import utils.SeleniumMethods;

public class SlideTeamSignUpPageObjects extends BaseTest{
	
	WebDriver driver;
	Properties prop;
	SeleniumMethods seleniumMethods;
	
	By signUpPageContent = By.xpath("//h3[@data-ui-id='page-title-wrapper']");
	By emailAddress = By.id("email_address");
	By firstName = By.id("firstname");
	By lastName = By.id("lastname");
	By password = By.id("password");
	By confirmPassword = By.id("password-confirmation");
	By offersCheckBox = By.id("is_subscribed");
	By signUpButton = By.id("final-submit");
	By countryDropDown = By.xpath("//button[@class='js-Dropdown-title']");
	By countriesList = By.xpath("//ul[contains(@class,'js-Dropdown-list')]/li");
	By phoneNumber = By.xpath("//input[@id='contact_number']");
	
	String expSignUpPageContent = "Create an Account";
	

    public SlideTeamSignUpPageObjects(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop;
    }
    
    public void verifySignPageContent() {
        String actSignUpPageContent = driver.findElement(signUpPageContent).getText();
        Assert.assertEquals(expSignUpPageContent, actSignUpPageContent);
    }
    
    public String getEmailAddress() {
    	seleniumMethods = new SeleniumMethods();
    	String email = seleniumMethods.emailGenerator();
    	return email;
    }
    
    public void enterSignUpDetails() {
    	String generatedEmailAddress = getEmailAddress();
    	driver.findElement(emailAddress).sendKeys(generatedEmailAddress);
    	driver.findElement(firstName).sendKeys(prop.getProperty("firstName"));
    	driver.findElement(lastName).sendKeys(prop.getProperty("lastName"));
    	driver.findElement(password).sendKeys(prop.getProperty("password"));
    	driver.findElement(confirmPassword).sendKeys(prop.getProperty("confirmPassword"));
    	driver.findElement(countryDropDown).click();
    	List<WebElement> countryList = driver.findElements(countriesList);
    	for(int i=0; i<countryList.size(); i++) {
    		String countryName = countryList.get(i).getText().split(" ")[0];
    		if(countryName.equalsIgnoreCase("Singapore"))
    		{
    			countryList.get(i).click();
    		}
    	}
    	driver.findElement(phoneNumber).sendKeys("789456123568");
    	driver.findElement(offersCheckBox).click();
    }
    
    public void clickOnSignUpButton() {
    	driver.findElement(signUpButton).click();
    }

}
