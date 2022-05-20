package com.johndeere.stepdefn;

import org.junit.Assert;

import com.johndeere.base.AutomationHooks;
import com.johndeere.base.DemoSize;
import com.johndeere.pages.DashboardPage;
import com.johndeere.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
	
public class LoginSteps  {
	private AutomationHooks hooks;
	private LoginPage login;
	private DashboardPage dashbord;
	
	public LoginSteps(AutomationHooks hooks,DemoSize obj)
	{
		this.hooks=hooks;
		System.out.println(obj.width);
		System.out.println(obj.height);
		obj.width=200;
	}

	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
		
		hooks.launchBrowser("ch");
		initializePageObject();
	}
	
	public void initializePageObject()
	{
		login=new LoginPage(hooks.driver);
		dashbord=new DashboardPage(hooks.driver);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		login.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		login.enterPassword(password);
	}

	@When("I select the language {string}")
	public void i_select_the_language(String language) {
		login.selectLanguageByText(language);
	}

	@When("I click on login")
	public void i_click_on_login() {
		login.clickOnLogin();
	}

	@Then("I should get access to the dashboard with title as {string}")
	public void i_should_get_access_to_the_dashboard_with_title_as(String expectedTitle) {
		
		dashbord.waitForPresenceOfPatientMenu();
		String actualTitle = dashbord.getDashboardPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedError) {
		
		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(expectedError,actualError);
	}
}
