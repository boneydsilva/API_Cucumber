package API.Listeners;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.Gson;

import utilities.ComparisionHolder;
import utilities.FileUtilities;
import utilities.jsonmanager.general.cucumber.CucumberReportContent;

public class testNgHooks implements ITestListener {

	static Date date = new Date();
	static long time = date.getTime();
	static Timestamp ts = new Timestamp(time);
	final static String id = ts.toString();

	@Override
	public void onStart(ITestContext context) {
		// System.out.println("on start");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// System.out.println("on test start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// System.out.println("on test sucess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// System.out.println("on test failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// System.out.println("on test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// System.out.println("on test failed but with success percentage");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on test finish");

		try {

			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

			extent.attachReporter(spark);

			String fileData = FileUtilities
					.readFile(System.getProperty("user.dir") + "/target/cucumber-reports/Cucumber.json");
			Gson gson = new Gson();
			CucumberReportContent report[] = gson.fromJson(fileData, CucumberReportContent[].class);
			HashMap<String, ArrayList<String>> error_values = ComparisionHolder.getComparedVarialbes();

			ExtentTest feature = extent.createTest(new GherkinKeyword(report[0].getKeyword()),
					report[0].getDescription());

			for (int i = 0; i < report.length; i++) {

				if (report[i].getElements().size() > 0) {

					String keyword_scenario = report[i].getElements().get(0).getKeyword();
					String Scenario_name = report[i].getElements().get(0).getName();

					ExtentTest scenario = feature.createNode(new GherkinKeyword(keyword_scenario), Scenario_name);

					for (int j = 0; j < report[i].getElements().get(0).getSteps().size(); j++) {

						String keyword = report[i].getElements().get(0).getSteps().get(j).getKeyword();
						String step = report[i].getElements().get(0).getSteps().get(j).getName();
						String status = report[i].getElements().get(0).getSteps().get(j).getResult().getStatus();

						if (status.equalsIgnoreCase("passed")) {
							scenario.createNode(new GherkinKeyword(keyword), step).pass("pass");
						} else if (status.equalsIgnoreCase("failed")) {

							String error = report[i].getElements().get(0).getSteps().get(j).getResult()
									.getErrorMessage().replace("utilities.myAssertionException: ", "").trim();

							String type = error_values.get(error).get(0);
							String Expected = error_values.get(error).get(1);
							String Actual = error_values.get(error).get(2);

							String code = "";

							Markup m = MarkupHelper.createCodeBlock(Expected, Actual);
							scenario.createNode(new GherkinKeyword(keyword), step).fail(m);

						} else if (status.equalsIgnoreCase("skipped")) {
							scenario.createNode(new GherkinKeyword(keyword), step).skip("skipped");
						}

						// report[0].getElements().get(0).getSteps().get(0).getResult().getStatus()
//System.out.println(report[0].getElements().get(0).getSteps().get(0).getResult().getErrorMessage().replace("utilities.myAssertionException: ",""));  error - 1

					}
				}
			}

			extent.flush();
		} catch (Exception e) {

		}

	}

}
