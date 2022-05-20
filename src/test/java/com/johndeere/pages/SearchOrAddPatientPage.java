package com.johndeere.pages;

import org.openqa.selenium.By;

import com.johndeere.base.AutomationHooks;

public class SearchOrAddPatientPage {
	private static By patFrameLocator=By.xpath("//iframe[@name='pat']");
	private static By firstnameLocator=By.id("form_fname");
	private static By lastnameLocator=By.id("form_lname");
	private static By createLocator=By.id("create");
	private static By confirmCreateLocator=By.xpath("//input[@value='Confirm Create New Patient']");
	private static By modalFrameLocator=By.xpath("//iframe[@id='modalframe']");

	public static void enterFirstname(String firstname) {
		AutomationHooks.driver.switchTo().frame(AutomationHooks.driver.findElement(patFrameLocator));
		AutomationHooks.driver.findElement(firstnameLocator).sendKeys(firstname);
	}

	public static void enterLastname(String lastname) {
		AutomationHooks.driver.findElement(lastnameLocator).sendKeys(lastname);
	}

	public static void clickOnCreateNewPatient() {
		AutomationHooks.driver.findElement(createLocator).click();
		AutomationHooks.driver.switchTo().defaultContent();
	}

	public static void clickOnConfirmCreateNewPatient() {
		AutomationHooks.driver.switchTo()
				.frame(AutomationHooks.driver.findElement(modalFrameLocator));
		AutomationHooks.driver.findElement(confirmCreateLocator).click();
		AutomationHooks.driver.switchTo().defaultContent();
	}
	
	
}
