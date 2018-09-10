package my.project.automation.wolfram_alpha;

//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
				/*features= {"src/test/resources/wolfram.feature"}*/
		features= {"src/test/resources/myntra.feature"}
		,glue= {"my.project.automation.wolfram_alpha"}
		)

public class cucumberTest extends AbstractTestNGCucumberTests{

	
}
