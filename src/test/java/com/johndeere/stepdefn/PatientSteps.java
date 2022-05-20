package com.johndeere.stepdefn;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.johndeere.base.AutomationHooks;
import com.johndeere.pages.DashboardPage;
import com.johndeere.pages.LoginPage;
import com.johndeere.pages.PatientDashboardPage;
import com.johndeere.pages.SearchOrAddPatientPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {
	private DashboardPage dashboard; 
	private SearchOrAddPatientPage sadp;
	private PatientDashboardPage pdp;
	
	private static String actualAlertText;
	
	
	public void initializePageObject()
	{
		dashboard=new DashboardPage(AutomationHooks.driver);
		sadp=new SearchOrAddPatientPage(AutomationHooks.driver);
		pdp=new PatientDashboardPage(AutomationHooks.driver);
	}

	@When("I click on Patient menu")
	public void i_click_on_patient_menu() {
		dashboard.clickOnPatient();
	}

	@When("I click on New search menu")
	public void i_click_on_new_search_menu() {
		dashboard.clickOnNewSearch();
	}

	@When("I fill the form")
	public void i_fill_the_form(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger ListigDecimal.

		List<Map<String, String>> lists = dataTable.asMaps();

		System.out.println(lists.get(0));
		System.out.println(lists.get(0).get("firstname"));
		System.out.println(lists.get(0).get("lastname"));
		System.out.println(lists.get(0).get("dob"));
		System.out.println(lists.get(0).get("gender"));
		System.out.println(lists.get(0).get("licencenumber"));

		sadp.enterFirstname(lists.get(0).get("firstname"));
		sadp.enterLastname(lists.get(0).get("lastname"));

		AutomationHooks.driver.findElement(By.id("form_DOB")).sendKeys(lists.get(0).get("dob"));
		new Select(AutomationHooks.driver.findElement(By.id("form_sex")))
				.selectByVisibleText(lists.get(0).get("gender"));
	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
		sadp.clickOnCreateNewPatient();
	}

	@When("I click on Confirm Create New Patient")
	public void i_click_on_confirm_create_new_patient() {
		sadp.clickOnConfirmCreateNewPatient();
	}

	@When("I handle the alert")
	public void i_handle_the_alert() {
		actualAlertText = pdp.getTextAndHandleAlert();
	}

	@When("I handle the happybirthday pop if available")
	public void i_handle_the_happybirthday_pop_if_available() {
		// presence of element
		pdp.clickOnCloseHappyBirthday();
	}

	@Then("alert message should contains {string}")
	public void alert_message_should_contains(String expectedAlert) {
		Assert.assertTrue(actualAlertText.contains(expectedAlert));
	}

	@Then("I should see the added patient details as {string}")
	public void i_should_see_the_added_patient_details_as(String expectedPatient) {
		String actualValue = pdp.getAddedPatientDetail();
		Assert.assertEquals(expectedPatient, actualValue);
	}

}
