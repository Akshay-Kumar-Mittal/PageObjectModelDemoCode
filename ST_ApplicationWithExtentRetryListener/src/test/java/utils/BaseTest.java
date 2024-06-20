package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	private boolean isDriverInitialized = false;

    @BeforeTest
	public void initializeDriver() throws IOException {
    	 if (!isDriverInitialized) {
    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//resources//ApplicationProperties.properties");
		prop = new Properties();
		prop.load(fis);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        isDriverInitialized = true;
    	    }
    }
    
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
    {
    	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenshots//"+ testCaseName + ".png"));
    	return System.getProperty("user.dir")+"//reports//"+ testCaseName + ".png";
    }
    

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
