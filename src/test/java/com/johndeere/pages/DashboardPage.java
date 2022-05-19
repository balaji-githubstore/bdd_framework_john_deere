package com.johndeere.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.johndeere.base.AutomationHooks;

public class DashboardPage {
	private static By patientLocator = By.xpath("//div[text()='Patient']");

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
}
