package my.project.automation.wolfram_alpha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import my.project.automation.wolfram_alpha.Properties;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver{

	protected static WebDriver driver;
	private static FileInputStream fileInputStream;
	private static final String driverPath="C:\\Users\\vuppara\\Documents\\driver\\chromedriver.exe";
	

	
	public  WebDriver getWebDriver() throws Exception {

		if (driver==null) {
		
			if (Prop.getUserProperty("browsername").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\vuppara\\Documents\\driver\\chromedriver.exe");
				driver= new ChromeDriver();

			} else {
				System.out.println("Enter a valid browser name in properties file");
			}
			
			return driver;
		}
		else 
			return driver;
		
		
	}

}
