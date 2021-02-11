package API.Listeners;

import org.testng.annotations.BeforeTest;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class BDDHooks {

	@Before
	public void before(Scenario s) {
//		System.out.println("Before Cucumber");
//		System.out.println(s.getName() );
	}

	@After
	public void after(Scenario s) {
//		System.out.println("After Cucumber");
	}
}
