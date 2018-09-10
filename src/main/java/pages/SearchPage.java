package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.BaseTestMethod;

import my.project.automation.wolfram_alpha.BaseMethods;
import my.project.automation.wolfram_alpha.Prop;
import my.project.automation.wolfram_alpha.Webdriver;

public class SearchPage extends LoginAndSignup{

	public WebDriver driver;
	public SearchPage(WebDriver driver) throws IOException  {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText="Men")
	private WebElement category;

	@FindBy(linkText="Topwear")
	private WebElement productType;

	@FindBy(className="brand-more")
	private WebElement selectBrand;
	
	@FindBy(xpath="//*[contains(@placeholder,'brand')]")
	private WebElement searchBrand;
	
	@FindBy(xpath="//span[contains(@class,'remove')]")
	private WebElement closeSearch;
	
	@FindBy(css=".FilterDirectory-list>li+li")
	private WebElement checkBrand;
	
	public void searchProduct() {
		moveAndClick(category,productType);
	}
	
	public void selectBrand(String brand) throws Exception {
		click(selectBrand);
		setValue(searchBrand, brand);
		click(checkBrand);
		click(closeSearch);
	}
}



