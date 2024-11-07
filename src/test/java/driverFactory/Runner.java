package driverFactory;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "FeatureFiles\\EmployeeReg.feature",
		monochrome = true,
		dryRun=false,
		glue="stepdefination",
		plugin = {"pretty","html:target/report/cucumber",
			"json:target/report/cucumber.json","junit:target/report/cucumber.xml"}
		
		
		)
public class Runner {

}
