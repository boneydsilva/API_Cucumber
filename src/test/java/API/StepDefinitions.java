package API;

import java.io.IOException;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utilities.myAssertionException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StepDefinitions {

	@Given("Get the list of users for page {string}")
	public void get_the_list_of_users_for_page(String string) throws IOException {

		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://reqres.in/api/users?page=1")
				  .method("GET", null)
				  .addHeader("Cookie", "__cfduid=d4552f79c2c69e1affcd7c00abc36aa261612856765")
				  .build();
				Response response = client.newCall(request).execute();
				
				System.out.println(response.body().string());
				
		}

	@When("Status code is {int}")
	public void status_code_is(Integer int1) throws Throwable {

		try {
			given()
				.get("https://reqres.in/api/users?page=1")
			.then()
				.statusCode(int1);

		} catch (Throwable t) {
			myAssertionException.myAssertion("200", int1 + "");
		}

	}

	@Then("Verify if there are only {int} responses")
	public void verify_if_there_are_only_responses(Integer int1) throws Throwable {

		RequestSpecification request1 = RestAssured.given();

		request1.header("Connection", "keep-alive");
		request1.header("Content-Type", "application/json");

		
		
		String perPage = "";
		try {

			io.restassured.response.Response response = request1.get("https://reqres.in/api/users?page=1");
			perPage = response.getBody().jsonPath().getString("per_page").toString();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		myAssertionException.myAssertion(perPage, int1 + "");

	}

	@Then("Verify if page is {string} as speciifed earlier")
	public void verify_if_page_is_as_speciifed_earlier(String expected) throws Throwable {
		RequestSpecification request1 = RestAssured.given();
		request1.header("Connection", "keep-alive");
		request1.header("Content-Type", "application/json");

		String Page = "";
		try {

			io.restassured.response.Response response = request1.get("https://reqres.in/api/users?page=1");
			Page = response.getBody().jsonPath().getString("page").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		myAssertionException.myAssertion(Page, expected);
	}

	@Then("Verify the response schema to code {string}")
	public void verify_the_response_schema_to_code(String string) {

//		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
//			      .setValidationConfiguration(
//			        ValidationConfiguration.newBuilder()
//			          .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
//			            .freeze();
//		
//		
//			    get("https://reqres.in/api/users?page=1").then().assertThat()
//			      .body(matchesJsonSchemaInClasspath("event_0.json")
//			        .using(jsonSchemaFactory));
//		
	}

	
	
	
	
	// myAssertionException.myAssertion("json", "asd", "vcd");
	@Given("First Api Tests {int}")
	public void first_api_tests(Integer int1) throws Throwable {
		System.out.println(int1);

	}

	@When("Second Api Tests {int}")
	public void second_api_tests(Integer int1) {
		System.out.println(int1);
	}

	@Then("Third Api Tests {int}")
	public void third_api_tests(Integer int1) throws Throwable {

		myAssertionException.myAssertion("json", "asd", "vcd");
	}
}
