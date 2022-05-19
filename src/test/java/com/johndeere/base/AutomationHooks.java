package com.johndeere.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class AutomationHooks {

	public static WebDriver driver;
	
	@After
	public void end()
	{
		AutomationHooks.driver.quit();
	}
	
	
}
