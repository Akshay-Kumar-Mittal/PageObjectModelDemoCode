package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
//	private boolean isDriverInitialized = false;

    @BeforeMethod(alwaysRun=true)
	public void initializeDriver() throws IOException {
//    	 if (!isDriverInitialized) {
    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//resources//ApplicationProperties.properties");
		prop = new Properties();
		prop.load(fis);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
//        isDriverInitialized = true;
//    	    }
    }
    

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
//        if (driver != null) {
            driver.quit();
//        }
    }

}
