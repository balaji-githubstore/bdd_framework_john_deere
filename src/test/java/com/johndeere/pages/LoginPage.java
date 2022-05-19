package com.johndeere.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.base.AutomationHooks;

public class LoginPage {
	private static By usernameLocator=By.id("authUser");
	private static By passwordLocator=By.id("clearPass");
	private static By languageLocator=By.xpath("//select[@name='languageChoice']");
	private static By loginLocator=By.cssSelector("#login-button");
	private static By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");
	
	public static void enterUsername(String username)
	{
		AutomationHooks.driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public static void enterPassword(String password)
	{
		AutomationHooks.driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public static void selectLanguageByText(String language)
	{
		Select selectLan = new Select(AutomationHooks.driver.findElement(languageLocator));
		selectLan.selectByVisibleText(language);
	}
	
	public static void clickOnLogin()
	{
		AutomationHooks.driver.findElement(loginLocator).click();
	}

	public static String getInvalidErrorMessage()
	{
		return AutomationHooks.driver.findElement(errorLocator).getText();
	}
	
}
