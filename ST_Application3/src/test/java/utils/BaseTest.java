package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	private boolean isDriverInitialized = false;

    @BeforeTest(alwaysRun=true)
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
    
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
    {
    	String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
    	ObjectMapper mapper = new ObjectMapper();
    	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
    	
    	return data;
    }

    @AfterTest(alwaysRun=true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
