package com.qa.hover.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait wait;
	
	//constructor of the class
	public ElementUtil(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 30);
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}catch(Exception e) {
			
		System.out.println("Some error occorued while creating element :" + element);
		}
		return element;
	}
	

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Click on Option from drop down List Without Select Class
	 * @param element
	 * @param value
	 */
	public void getOptions(List<WebElement> element, String value) {
		int size = element.size();
		for(int i=0;i<size;i++)
		{
			String click = element.get(i).getText();
			if(click.equals(value))
			{
			element.get(i).click();
			break;
			}
		}
	}
	
	
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
		elements = driver.findElements(locator);
		}catch(Exception e) {
			
		System.out.println("Some error occorued while creating element :" + elements);
		}
		return elements;
	}
	
	
	public String selectClassAction(By locator, String value){
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);	
		return select.getFirstSelectedOption().getText();
	}
	
	
}
