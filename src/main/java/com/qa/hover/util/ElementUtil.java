package com.qa.hover.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		WebElement element = null ;
		try {
		element = driver.findElement(locator);
		}catch(Exception e) {
			
		System.out.println("Some error occorued while creating element :" + locator);
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
	 * Java Script Click 
	 * @param locator
	 */
	public void clickElementByJS(By locator)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",getElement(locator));
	}
	/**
	 * JS Scroll Pg Down
	 */
	
	public void scrollByPixel()
	{
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	
	/**
	 * Actioon class click
	 */
	public void doClickAction(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
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
			
		System.out.println("Some error occorued while creating element :" + locator);
		}
		return elements;
	}
	
	
	public String selectClassAction(By locator, String value){
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);	
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Check Active links or broken link on page
	 * @param links
	 */
	public void getActiveLinks(List<WebElement> links) {
		
		for(int i =0;i<links.size();i++) {
			
			URL url;
			try {
				url = new URL(links.get(i).getAttribute("href"));
				HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
				httpconnection.connect();
				String msg = httpconnection.getResponseMessage();
				//int code = httpconnection.getResponseCode();
				httpconnection.disconnect();
				System.out.println(links.get(i).getAttribute("href")+ " ----> " + msg);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
