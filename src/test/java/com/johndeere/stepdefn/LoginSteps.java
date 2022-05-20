package com.johndeere.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.johndeere.base.AutomationHooks;
import com.johndeere.pages.DashboardPage;
import com.johndeere.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps  {
	
	private LoginPage login;
	private DashboardPage dashbord;

	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
		WebDriverManager.chromedriver().setup();
		AutomationHooks.driver = new ChromeDriver();
		AutomationHooks.driver.manage().window().maximize();
		AutomationHooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		AutomationHooks.driver.get("http://demo.openemr.io/b/openemr");
		
		initializePageObject();
	}
	
	public void initializePageObject()
	{
		login=new LoginPage(AutomationHooks.driver);
		dashbord=new DashboardPage(AutomationHooks.driver);
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
