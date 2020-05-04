package com.qa.hover.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

import com.qa.hover.base.BasePage;
import com.qa.hover.util.ElementUtil;

public class TaskPage2 extends BasePage{

	WebDriver driver;
	ElementUtil elementutil;
	
	/**
	 * Validate Link title for all Similar Product.
	 *6. Check all link are working correct and Redirect to same link or not.
	 *7. Check if there is any broken Link available or not.
	 *8. Check Step 6 and 7 for All Categories and all Collection.
	 *9. Print Result of Step 6 and Step 7 and Step 8. 
	 *10. Close
	 */
	
	//By Locators
	By links = By.tagName("a");
	By labelcheck = By.xpath("//div[@id='primary']/following::aside[1]/h3");
	By teninchhoverboard = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[1]/a"); 
	
	public TaskPage2(WebDriver driver){
		this.driver=driver;
		elementutil = new ElementUtil(this.driver);
	}
	
	//Check all link are working correct and Redirect to same link or not.
	
	public String checkAllActiveLinks() {
	List<WebElement> link = elementutil.getElements(links);
	System.out.println(link.size());
	List<WebElement> activelink = new ArrayList<WebElement>();
	
	for(int i=0;i<link.size();i++)
	{
	// System.out.println(link.get(i).getAttribute("href"));
	 if(link.get(i).getAttribute("href") != null && (!link.get(i).getAttribute("href").contains("mailto"))) {
		 activelink.add(link.get(i));}
	}
	
	// elementutil.getActiveLinks(activelink);

	
	return elementutil.getElement(labelcheck).getText();
		
	}
	
	public CategoryLinkCheckPage3 gotoCategoryLinkCheckPage3() {
	
	//elementutil.doClick(teninchhoverboard);
	return new CategoryLinkCheckPage3(driver);
	}
	
}
