package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SlideTeamCheckoutPageObjects {
	
	WebDriver driver;
	
	By stripeRadioButton = By.xpath("//input[@class='radio']");
	By paymentInfoMonthlyWith10DownloadPrice = By.xpath("//input[@name='ko_unique_1']//following-sibling::span");
	By orderReviewMonthlyPrice = By.xpath("//tr[@class='monthly']//span");
	By secureCheckoutButton = By.id("place-order-trigger");

    public SlideTeamCheckoutPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyCheckoutPageTitle() {
    	Assert.assertEquals(driver.getTitle(), "Checkout");
    }
    
    public String verifyPaymentInfoPrice() {
    	return driver.findElement(paymentInfoMonthlyWith10DownloadPrice).getText().split("-")[1].trim();
    }

    public String verifyOrderReviewPrice() {
    	return driver.findElement(orderReviewMonthlyPrice).getText();
    }
    
    public void clickOnSecureCheckoutButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(secureCheckoutButton));
    	driver.findElement(secureCheckoutButton).click();
    }
}
