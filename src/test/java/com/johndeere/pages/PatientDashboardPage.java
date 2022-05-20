package com.johndeere.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.johndeere.base.AutomationHooks;

public class PatientDashboardPage {
	private static By closeHBDLocator=By.xpath("//div[@class='closeDlgIframe']");
	private static By patFrameLocator=By.xpath("//iframe[@name='pat']");
	private static By patientDetailLocator=By.xpath("//h2[contains(text(),'Record')]");
	public static String getTextAndHandleAlert() {
		WebDriverWait wait = new WebDriverWait(AutomationHooks.driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());

		String alertText = AutomationHooks.driver.switchTo().alert().getText();
		AutomationHooks.driver.switchTo().alert().accept();

		return alertText;
	}

	public static void clickOnCloseHappyBirthday() {
		if (AutomationHooks.driver.findElements(closeHBDLocator).size() > 0) {
			AutomationHooks.driver.findElement(closeHBDLocator).click();
		}
	}

	public static String getAddedPatientDetail() {
		AutomationHooks.driver.switchTo().frame(AutomationHooks.driver.findElement(patFrameLocator));
		return AutomationHooks.driver.findElement(patientDetailLocator).getText().trim();
	}
}
