package stepdef.connector;
import java.io.IOException;

import my.project.automation.wolfram_alpha.Webdriver;
import my.project.automation.wolfram_alpha.Prop;
import pages.LoginAndSignup;
import pages.SearchPage;

public class MyntraConnector extends Webdriver {

	private LoginAndSignup loginAndSignup;
	private SearchPage searchPage;
	 
	
	public void openMyntra(String url) throws Exception {
		driver=getWebDriver();
		driver.navigate().to(Prop.getUserProperty(url));
		driver.manage().window().maximize();
		loginAndSignup = new LoginAndSignup(driver);
		searchPage = new SearchPage(driver);
}
	
	public void login(String user,String password)  {
		loginAndSignup.clickLogin();
		loginAndSignup.loginToMyntra(user, password);
	}
	
	public void signup() {
		loginAndSignup.clickSignup();
	}
	
	public void searchProduct() {
		searchPage.searchProduct();
	}

	public void selectBrand(String brand) throws Exception {
		searchPage.selectBrand(brand);
	}
	
	public void displayResults() {
		System.out.println("I hope your results are displayed well");
	}
	
}
