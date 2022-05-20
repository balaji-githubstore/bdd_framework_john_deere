package com.johndeere.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//to rerun failed test scenario features = {"@target/rerun.txt"}
@CucumberOptions(
		features = {"@target/rerun.txt"}
		,glue = {"com.johndeere.stepdefn","com.johndeere.base"}
		,publish = true
		,monochrome = true
		,plugin = {"rerun:target/rerun.txt","pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"}
		//,dryRun = true
//		,tags = "@valid or @patient"
		,tags="@invalid"
		)

@RunWith(Cucumber.class)
public class RunnerFailedTest {

}
