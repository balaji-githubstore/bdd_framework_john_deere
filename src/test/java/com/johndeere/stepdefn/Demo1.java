package com.johndeere.stepdefn;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1 {

	@Given("I have browser")
	public void i_have_browser() {

	}

	@When("I fill the data")
	public void i_fill_the_data(DataTable dataTable) {
		List<Map<String, String>> lists=dataTable.asMaps();
		
		System.out.println(lists.get(0).get("firstname"));
		System.out.println(lists.get(0).get("lastname"));
		System.out.println(lists.get(0).get("dob"));
	}

	@Then("I should see output")
	public void i_should_see_output() {

	}

}
