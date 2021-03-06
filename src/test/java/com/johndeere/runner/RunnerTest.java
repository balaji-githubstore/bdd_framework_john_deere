package com.johndeere.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Feature"}
		,glue = {"com.johndeere.stepdefn","com.johndeere.base"}
		,publish = true
		,monochrome = true
		,plugin = {"rerun:target/rerun.txt","pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"}
		//,dryRun = true
		,tags = "@invalid"
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
