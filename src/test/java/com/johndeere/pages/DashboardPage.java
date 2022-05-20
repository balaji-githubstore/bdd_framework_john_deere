package com.johndeere.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.johndeere.base.AutomationHooks;
//all menu will be handled here
public class DashboardPage {
	private static By patientLocator = By.xpath("//div[text()='Patient']");
	private static By newSearchLocator = By.xpath("//div[text()='New/Search']");
	
	
	public static void waitForPresenceOfPatientMenu() {
		WebDriverWait wait = new WebDriverWait(AutomationHooks.driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(patientLocator));
	}

	public static String getDashboardPageTitle() {
		return AutomationHooks.driver.getTitle();
	}

	public static void clickOnPatient() {
		AutomationHooks.driver.findElement(patientLocator).click();
	}
	public static void clickOnNewSearch() {
		AutomationHooks.driver.findElement(newSearchLocator).click();
	}
}
