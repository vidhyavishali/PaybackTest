/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.apptest.screens;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apptest.utils.LOCATORS;
import com.apptest.utils.SessionManager;

public class AppScreenBase {
	protected final static Logger logger = Logger.getLogger(AppScreenBase.class);
	private static WebDriver driver;
	public WebDriverWait wait;
	static SessionManager instance = SessionManager.getInstance();

	/**
	 * Retrieves the session driver from the session manager during initialization
	 */
	public AppScreenBase() {
		driver = instance.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Clicks the specified web element
	 */
	public void clickElement(WebElement ele) {
		String text = "";
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			text = ele.getText();
			ele.click();
			logger.info("The Element " + text + " is clicked");
		} catch (Exception e) {
			logger.error("The Element " + text + " could not be clicked");
			throw new RuntimeException();
		}

	}

	/**
	 * Returns the text attribute of the element
	 */
	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	/**
	 * Retrieves the web element by locating based on locator and locator value
	 */
	public WebElement getWebElement(LOCATORS locator, String locValue) {
		switch (locator) {
		case ID:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locValue)));
			return driver.findElement(By.id(locValue));
		case NAME:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locValue)));
			return driver.findElement(By.name(locValue));
		case CLASS:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locValue)));
			return driver.findElement(By.className(locValue));
		case LINKTEXT:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locValue)));
			return driver.findElement(By.linkText(locValue));
		case PARTIAL_LINKTEXT:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locValue)));
			return driver.findElement(By.partialLinkText(locValue));
		case TAG:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locValue)));
			return driver.findElement(By.tagName(locValue));
		case CSSSELECTOR:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locValue)));
			return driver.findElement(By.cssSelector(locValue));
		case XPATH:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locValue)));
			return driver.findElement(By.xpath(locValue));
		}
		return null;
	}

	/** Retrieves list of web elements based on locator and locator value */
	public List<WebElement> getWebElementList(LOCATORS locator, String locValue) {
		switch (locator) {
		case ID:
			return driver.findElements(By.id(locValue));
		case NAME:
			return driver.findElements(By.name(locValue));
		case CLASS:
			return driver.findElements(By.className(locValue));
		case LINKTEXT:
			return driver.findElements(By.linkText(locValue));
		case PARTIAL_LINKTEXT:
			return driver.findElements(By.partialLinkText(locValue));
		case TAG:
			return driver.findElements(By.tagName(locValue));
		case CSSSELECTOR:
			return driver.findElements(By.cssSelector(locValue));
		case XPATH:
			return driver.findElements(By.xpath(locValue));
		}
		return null;
	}

}
