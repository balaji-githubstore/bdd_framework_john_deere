package com.johndeere.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Feature/Login.feature"})

@RunWith(Cucumber.class)
public class RunnerTest {

}
