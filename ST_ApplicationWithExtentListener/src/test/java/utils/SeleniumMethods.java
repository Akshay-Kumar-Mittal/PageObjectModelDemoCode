package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethods {
	
	public String emailGenerator(){
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
		    Date date = new Date();  
		    String email = "testuser"+formatter.format(date)+"@gmail.com";
		        System.out.println(email);
		        return email;
		    }
	
}
