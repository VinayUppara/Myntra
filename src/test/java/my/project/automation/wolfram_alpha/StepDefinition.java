package my.project.automation.wolfram_alpha;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.*;
import stepdef.connector.Connector;
import stepdef.connector.MyntraConnector;

public class StepDefinition extends MyntraConnector {

	
	private MyntraConnector myntraConnector = new MyntraConnector();

	/*private Connector connector= new Connector();
	 * @Given("URL of WolframeAlpha")
	public void openURL() throws Exception {
		connector.openWolfram();
	}

	@When("user logged in as {string} with {string}")
	public void loginToSite(String user, String password) throws Exception {
		connector.signIn();
		connector.name(user);
		connector.password(password); 
		
	}

	@When("^login is succesfull$")
	public void loginIsSuccesfull() {
		// TODO Auto-generated method stub
		System.out.println("Login is succesfull to WolframAlpha");
	}

	@When("user searchs for a {string}")
	public void searchTopic(String topic) throws Exception {
		connector.search(topic);
		connector.submit();
	}

	@Then("^Results are displayed in creative way$")
	public void displayResults() {
		System.out.println("Results are displayed successfully");
	}
*/
		@Given("^\"([^\"]*)\" of Myntra$")
		public void openMyntraSite(String url) throws Exception {
			myntraConnector.openMyntra(url);
		}
		
		@When("User logged in with {string} and {string}")
		public void loginToMyntra(String user, String pass) {
			myntraConnector.login(user, pass);
		}
		@When("Selects a category")
		public void selectCategory() {
			myntraConnector.searchProduct();
		}
		@When("Search for a {string}")
		public void searchBrand(String brand) throws Exception {
			myntraConnector.selectBrand(brand);
		}
		
		@Then("^Results are displayed$")
		public void displayResults() {
		myntraConnector.displayResults();	
		}

}
