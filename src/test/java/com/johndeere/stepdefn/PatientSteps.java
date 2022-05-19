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

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {
	private static String actualAlertText;

	@When("I click on Patient menu")
	public void i_click_on_patient_menu() {
		AutomationHooks.driver.findElement(By.xpath("//div[text()='Patient']")).click();
	}

	@When("I click on New search menu")
	public void i_click_on_new_search_menu() {
		AutomationHooks.driver.findElement(By.xpath("//div[text()='New/Search']")).click();
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

		AutomationHooks.driver.switchTo().frame(AutomationHooks.driver.findElement(By.xpath("//iframe[@name='pat']")));

		AutomationHooks.driver.findElement(By.id("form_fname")).sendKeys(lists.get(0).get("firstname"));
		AutomationHooks.driver.findElement(By.id("form_lname")).sendKeys(lists.get(0).get("lastname"));
		AutomationHooks.driver.findElement(By.id("form_DOB")).sendKeys(lists.get(0).get("dob"));
		new Select(AutomationHooks.driver.findElement(By.id("form_sex")))
				.selectByVisibleText(lists.get(0).get("gender"));
	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
		AutomationHooks.driver.findElement(By.id("create")).click();

		AutomationHooks.driver.switchTo().defaultContent();
	}

	@When("I click on Confirm Create New Patient")
	public void i_click_on_confirm_create_new_patient() {
		AutomationHooks.driver.switchTo()
				.frame(AutomationHooks.driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		AutomationHooks.driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		AutomationHooks.driver.switchTo().defaultContent();
	}

	@When("I handle the alert")
	public void i_handle_the_alert() {
		WebDriverWait wait = new WebDriverWait(AutomationHooks.driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());

		actualAlertText = AutomationHooks.driver.switchTo().alert().getText();
		AutomationHooks.driver.switchTo().alert().accept();
	}

	@When("I handle the happybirthday pop if available")
	public void i_handle_the_happybirthday_pop_if_available() {
		// presence of element
		if (AutomationHooks.driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size() > 0) {
			AutomationHooks.driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		}
	}

	@Then("alert message should contains {string}")
	public void alert_message_should_contains(String expectedAlert) {

		Assert.assertTrue(actualAlertText.contains(expectedAlert));
	}

	@Then("I should see the added patient details as {string}")
	public void i_should_see_the_added_patient_details_as(String expectedPatient) {
		AutomationHooks.driver.switchTo().frame(AutomationHooks.driver.findElement(By.xpath("//iframe[@name='pat']")));

		String actualValue = AutomationHooks.driver.findElement(By.xpath("//h2[contains(text(),'Record')]")).getText()
				.trim();
		
		Assert.assertEquals(expectedPatient, actualValue);
	}

}
