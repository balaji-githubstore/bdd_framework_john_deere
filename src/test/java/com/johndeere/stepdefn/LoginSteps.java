package com.johndeere.stepdefn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
	    System.out.println("browser launch");
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
	    System.out.println("enter username "+username);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
	    
	}
	@When("I select the language {string}")
	public void i_select_the_language(String string) {
	    
	}
	@When("I click on login")
	public void i_click_on_login() {
	    
	}
	@Then("I should get access to the dashboard with title as {string}")
	public void i_should_get_access_to_the_dashboard_with_title_as(String string) {
	    
	}

}
