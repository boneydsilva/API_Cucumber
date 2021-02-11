package API;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/API" },
				tags = "@sampleTest",
				 glue = { "API" }, 
				
				 plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json" })
@Listeners({API.Listeners.testNgHooks.class})


public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
