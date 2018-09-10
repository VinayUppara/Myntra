package pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.project.automation.wolfram_alpha.BaseMethods;


public class LoginAndSignup extends BaseMethods{


	 
	//protected BaseMethods baseMethods = new BaseMethods();
	public WebDriver driver;


	public LoginAndSignup(WebDriver driver) throws IOException{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@data-reactid='512']")
	private WebElement account;

	@FindBy(xpath="//*[.='login']")
	private WebElement login;

	@FindBy(xpath="//*[.='signup']")
	private WebElement signup;

	@FindBy(name="email")
	private WebElement mail;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath="//button[.='Log in']")
	private WebElement clickLogin;

	/*@FindBy(name="j_username")
	private WebElement userName;

	@FindBy(name="j_password")
	private WebElement password;

	@FindBy(name="login")
	private WebElement login;*/

	public void clickLogin()  {

		/*driver=getWebDriver();
		driver.navigate().to(Prop.getUserProperty("url"));
		driver.manage().window().maximize();*/
		click(account);
		if(login.isDisplayed()) 
		{
			click(login);
		}

		else {
			System.out.println("ALready logged in to Myntra");
		}
		/*Set<String> id = driver.getWindowHandles();
		Iterator<String> ids = id.iterator();
		while(ids.hasNext()) {
			driver.switchTo().window(ids.next());
			new Select(login)*/
	}

	public void clickSignup() {

		click(account);
		if(signup.isDisplayed()) {
			click(signup);	
		}
		else {
			System.out.println("ALready logged in to Myntra");
		}
	}

	public void loginToMyntra(String str1,String str2) {
		setValue(mail,str1);
		typeAndSubmit(password,str2);
		
	}

	public void signupToMyntra() {

	}



}
