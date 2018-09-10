package my.project.automation.wolfram_alpha;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseMethods extends Webdriver {

	Actions actions = new Actions(driver);
	
	public void click(WebElement ele)  {
		ele.click();
		/*new WebDriverWait(driver, 60).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals(TmagConstants.TMAG_COMPLETE));
		*/}

			public void jsClick(WebElement ele) throws Exception {
				waitForClick(ele);
				JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
				jsexecutor.executeScript("args[0].click()", ele);
			}
			public void waitForClick(WebElement ele, int time) {
				// TODO Auto-generated method stub
				 
				new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(ele));
				
			}
			public void waitForClick(WebElement ele) throws Exception{
				 
				new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(ele));
			}
			public void jsWaitClick(WebElement ele) throws Exception {
				waitForClick(ele);
				jsClick(ele);
				
			}
			public void waitFor(WebElement ele, int time) {
				 
				new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(ele));
			}

			public void waitFor(WebElement ele) throws Exception {
				 
				new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(ele));
				
			}
			
			/*private void waitForPage() {
				try {
					new WebDriverWait(driver, 60).until((org.openqa.selenium.support.ui.ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
							.executeScript("return document.readyState").equals("complete"));
				} catch (Exception e) {
				
				}
			}*/
			

			public void setValue(WebElement ele, String str){
				waitFor(ele, 15);
				ele.sendKeys(str);
			}

			public boolean isAlertPresent() {
				boolean foundAlert = false;
				WebDriverWait wait = new WebDriverWait(driver, 20);
				try {
					wait.until(ExpectedConditions.alertIsPresent());
					foundAlert = true;
				} catch (org.openqa.selenium.TimeoutException e) {
					/*log.info("Alert not present: " + e);*/
				}
				return foundAlert;
			}

			
			public void switchToWindowByURL(String urlToSwitch) {
				Set<String> allWindows = driver.getWindowHandles();
				for (String currentWindow : allWindows) {
					if (driver.switchTo().window(currentWindow).getCurrentUrl().contains(urlToSwitch)) {
						driver.switchTo().window(currentWindow);
						return;
					}
				}
			}

			public void verifyCertificate() throws Exception {
				if ("Certificate Error: Navigation Blocked".equalsIgnoreCase(driver.getTitle()))
					waitAndClick(driver.findElement(By.cssSelector("#overridelink")), 20);
			}

			public void waitAndClick(WebElement ele, int time) throws Exception {
				waitForClick(ele,time);
				click(ele);
			}

			protected void navigateTo(String url) {
				driver.get(url);
				driver.manage().window().maximize();
			}

			public void switchToParentWindow() {
				driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
			}

			/*public void switchToSecondWindow() {
				waitFor(ExpectedConditions.numberOfWindowsToBe(2), 30);
				Object window1 = driver.getWindowHandles().toArray()[1];
				driver.switchTo().window((String) window1);
				
			}*/

			/*public void waitFor(ExpectedCondition<Boolean> numberOfWindowsToBe,
					int time) {
				// TODO Auto-generated method stub
				 
				
				
			}*/
		/*
			public void switchToSecondWindow(int time) {
				waitFor(ExpectedConditions.numberOfWindowsToBe(2), time);
				Object window1 = driver.getWindowHandles().toArray()[1];
				driver.switchTo().window((String) window1);
				
			}*/

			public int getWindowsOpen() {
				return driver.getWindowHandles().size();
			}

			public void closeAllWindows() {
				String mainWindow = driver.getWindowHandle();
				for (int i = driver.getWindowHandles().size() - 1; i > 0; i--) {

					String winHandle = driver.getWindowHandles().toArray()[i].toString();
					if (!winHandle.equals(mainWindow)) {
						driver.switchTo().window(winHandle);
						driver.close();
					}
				}
				driver.switchTo().window(mainWindow);
			}

			
			public void switchFrame(WebElement ele) throws Exception {
				try {
					driver.switchTo().defaultContent();
					waitFor(ele);
					driver.switchTo().frame(ele);
				} catch (org.openqa.selenium.ElementNotVisibleException e) {
					/*log.error(e.getMessage() + e);*/
				}
			}

			public void switchFrameInFrame(WebElement frame, WebElement frame2) throws Exception {
				try {
					driver.switchTo().defaultContent();
					waitFor(frame);
					driver.switchTo().frame(frame).switchTo().frame(frame2);
				} catch (org.openqa.selenium.ElementNotVisibleException e) {
					/*log.error(e.getMessage() + e);*/
				}
			}

			public void switchToDefault() {
				driver.switchTo().defaultContent();
			}

			public void acceptAlert() {
				try {
					if (isAlertPresent()) {
						driver.switchTo().alert().accept();
						driver.switchTo().defaultContent();
						 
					}
				} catch (Exception e) {
					/*log.info("Exception occured in alert handling." + e);*/
				}
			}

			public void dismissAlert() {
				if (isAlertPresent()) {
					driver.switchTo().alert().dismiss();
					driver.switchTo().defaultContent();
					 
				}
			}

			private String parentWindow;

			protected String getParentWindowHandle() {
				return parentWindow;
			}

			/*protected boolean getWindowByTitlePartial(String targetTitle, int waitTime) {

				for (int i = 0; i < waitTime; i++) {

					Set<String> handles = driver.getWindowHandles();
					for (String handle : handles) {
						if (!handle.equalsIgnoreCase(parentWindow)) {
							try {
								driver.switchTo().window(handle);
							} catch (UnhandledAlertException e) {
								log.error("Error: " + e);
							}
							String currentTitle = driver.getTitle();
							if (currentTitle.contains(targetTitle)) {
								return true;
							}
						}
					}
				}
				return false;
			}*/

			public boolean isElementPresent(WebElement ele) {
				boolean flag = false;
				try {
					flag = ele.isDisplayed();
				} catch (Exception e) {
					/*log.error("Element not present" + ele);*/
				}
				return flag;
			}

			
			
			public void verifyPageLoad(String page, WebElement ele) {
				 
				isElementPresent(ele);
				/*log.info(" {} page loaded successfully.", page);*/
			}

			
			/*protected void elementListLoop(List<WebElement> elements, String condition) {
				for (WebElement ele : elements) {
					log.info("Available Elements: {}", ele.getText());
					if (ele.getText().contains(condition)) {
						waitFor(ele, 60);
						jsClick(ele);
						break;
					}
				}
			}*/


			protected void ddSelectionByValue(WebElement ele, String value) throws Exception {
				waitFor(ele, 60);
				org.openqa.selenium.support.ui.Select sel = new org.openqa.selenium.support.ui.Select(ele);
				sel.selectByValue(value);
				/*log.info("Element selected from dropDown {}" ,ele);*/
			}

			/*public void assertion(String reason, String pageTitle, boolean assertion) {
				MatcherAssert.assertThat(reason + " on " + pageTitle, assertion);
			}*/

			public void isPageLoaded(WebElement ele, String page) {
				 
				if (isElementPresent(ele)) {
					
				}
				/*	log.info("{} page loaded successfully", page);*/
				else {
					/*log.error("{} page failed to load", page);*/
				}
			}
			
			public void moveAndClick(WebElement ele1, WebElement ele2) {
				
				actions.moveToElement(ele1).click(ele2).build().perform();
			}
			
			public void typeAndSubmit(WebElement ele,String str) {
				actions.sendKeys(ele,str).sendKeys(Keys.ENTER);
			}

			protected String getTextFromEelemnt(WebElement ele) throws Exception {
				waitFor(ele);
				return ele.getText();
			}
			
			public void scrollForElement(WebElement ele) throws Exception{
				 
				((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
				new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(ele));
				
			}
			public void close() {
				driver.close();
			}

}
