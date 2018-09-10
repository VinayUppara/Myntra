package stepdef.connector;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;

import my.project.automation.wolfram_alpha.Prop;
import my.project.automation.wolfram_alpha.Webdriver;
import pages.HomeAndLogin;
import pages.SearchPage;

public class Connector extends Webdriver {

	
	/*private HomeAndLogin homeAndLogin; = new HomeAndLogin(Webdriver.getWebDriver());
	private SearchPage searchPage=new SearchPage(Webdriver.getWebDriver());
	 */
	public void openWolfram() throws Exception {
		driver=getWebDriver();
		System.out.println(driver.getClass().toString());
		driver.navigate().to(Prop.getUserProperty("url"));
		driver.manage().window().maximize();
}
	
	public void signIn() throws IOException {
		new HomeAndLogin(driver).signin();
	}
	public void name(String user) throws Exception {
		new HomeAndLogin(driver).enterUserName(user); 
	}

	public void password(String password) throws Exception {
		new HomeAndLogin(driver).enterPassword(password);
		new HomeAndLogin(driver).login();
		
	}

	public void search(String topic) throws Exception {
		new SearchPage(driver).Search(topic);

	}

	public void submit() throws IOException {
		new SearchPage(driver).Submit();
	}
}

