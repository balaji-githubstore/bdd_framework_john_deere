package com.johndeere.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.johndeere.base.AutomationHooks;
import com.johndeere.pages.DashboardPage;
import com.johndeere.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps  {

	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
		WebDriverManager.chromedriver().setup();
		AutomationHooks.driver = new ChromeDriver();
		AutomationHooks.driver.manage().window().maximize();
		AutomationHooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		AutomationHooks.driver.get("http://demo.openemr.io/b/openemr");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		LoginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		LoginPage.enterPassword(password);
	}

	@When("I select the language {string}")
	public void i_select_the_language(String language) {
		LoginPage.selectLanguageByText(language);
	}

	@When("I click on login")
	public void i_click_on_login() {
		LoginPage.clickOnLogin();
	}

	@Then("I should get access to the dashboard with title as {string}")
	public void i_should_get_access_to_the_dashboard_with_title_as(String expectedTitle) {
		
		DashboardPage.waitForPresenceOfPatientMenu();
		String actualTitle = DashboardPage.getDashboardPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedError) {
		
		String actualError = LoginPage.getInvalidErrorMessage();
		Assert.assertEquals(expectedError,actualError);
	}
}
