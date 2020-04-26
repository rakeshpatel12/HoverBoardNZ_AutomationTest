package com.qa.hover.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hover.base.BasePage;
import com.qa.hover.util.ElementUtil;

public class TaskPage1 extends BasePage{
	
	WebDriver driver;
	ElementUtil elementutil;

	/**
	* Task: Find out Lowest and highest Product value.

	1. Go to this URL: https://hoverboardnz.co.nz/
	2. Type Hoverboard in Search and Select all category and Click on Submit.
	3. You will get list of hoverboard in you page and left-hand side you will get different hoverboard category.
	4. Select Show dropdown value to 36
	5. Print all the hoverboard name value with price on the console. (Verify if Page 2 is available then print all the hoverboard name value in console.)
	6. Find out Lowest Hoverboard value and name using sorting order.
	7. Find out Highest hoverboard value and name using sorting order.
	 */
	
	//By locators
	
	By searchTxt = By.name("s");
	By categoryClick = By.xpath("//div[@class='selectric']");
	By categorySelect = By.xpath("//div[@class='selectric-scroll']//li");
	By clickSubmit = By.id("yith-searchsubmit");
	
	//Dropdown
	//By dropclick1 = By.xpath("//label[contains(text(),'Sort By:')]/following::select[2]");
	By dropclick36 = By.xpath("//label[contains(text(),'Sort By:')]/following::select[2]/option[3]");
	
//	By dropDownValue = By.name("count");
//	By dropDownValueclick = By.xpath("//select[@name='count' and @class='count']//option");
	
	By hoverBoardName = By.xpath("//h3[@class='woocommerce-loop-product__title']");
	By hoverBoardPrice = By.xpath("//span[@class='price']//ins");
	By pages = By.xpath("//div[@class='shop-loop-after clearfix']//following::ul[@class='page-numbers']//li");
	By pageno = By.linkText("2");
	By sortbyvalue = By.name("orderby");
	By sortOrder_HoverBoardName = By.xpath("//div[@class='description']//preceding::h3");
	By sortOrder_HoverBoardValue = By.xpath("//span[@class='price']//ins");
	//Label text for assert
	By testtxt1 = By.xpath("//ul[@class='breadcrumb']//li[3]");
	
	//Constructor of the class
	public TaskPage1(WebDriver driver){
		this.driver=driver;
		elementutil = new ElementUtil(this.driver);
	}
	
	//Search for HoverBoard
	public String SearchForHoverBoard() {
		
		elementutil.waitForElementPresent(searchTxt);
		elementutil.doSendKeys(searchTxt, "Hoverboard");
		
		elementutil.doClick(categoryClick);
		List<WebElement> list =elementutil.getElements(categorySelect);
		elementutil.getOptions(list, "All Categories");
		
		
		elementutil.doClick(clickSubmit);
		
		elementutil.waitForElementPresent(testtxt1);
		return elementutil.getElement(testtxt1).getText();
	}
	
	
	public String printAllHoverBoardValueAndPrice() {
		
	   //Select drop down value to 36 and print
		elementutil.waitForElementPresent(dropclick36);
		elementutil.doClick(dropclick36);
		elementutil.waitForElementPresent(hoverBoardName);

		List<WebElement> name = elementutil.getElements(hoverBoardName);
		List<WebElement> price = elementutil.getElements(hoverBoardPrice);
		System.out.println(name.size());
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i).getText());
			System.out.println(price.get(i).getText() + "\n");

		}

		List<WebElement> listpage = elementutil.getElements(pages);
		if (listpage.size() > 0) {
			elementutil.doClick(pageno);
			elementutil.waitForElementPresent(hoverBoardName);
			System.out.println("===========Page 2 ===========\n");
			List<WebElement> name2 = elementutil.getElements(hoverBoardName);
			List<WebElement> price2 = elementutil.getElements(hoverBoardPrice);
			for (int j = 0; j < name2.size(); j++) {
				System.out.println(name2.get(j).getText());
				System.out.println(price2.get(j).getText() + "\n");

			}

		}
		
		return elementutil.doGetCurrentUrl();


	}

	//print lowest value hoverboard name
	public String lowestValueHoverBoardName() {
		
		String lowvalue = elementutil.selectClassAction(sortbyvalue, "Sort by price: low to high");
		elementutil.waitForElementPresent(hoverBoardName);
		
		 System.out.println("Lowest Price HoverBoard and HoverBoard Name \n");
		 
		 System.out.println(elementutil.getElement(sortOrder_HoverBoardName).getText());
		 System.out.println(elementutil.getElement(sortOrder_HoverBoardValue).getText());
		 return lowvalue;
		
	}

	// find highest value hoverboard name
	public String highestValueHoverBoardName() {
		
		elementutil.waitForElementPresent(sortbyvalue);
		String highvalue = elementutil.selectClassAction(sortbyvalue, "Sort by price: high to low");
		elementutil.waitForElementPresent(hoverBoardName);
		
		 System.out.println("\nHighest Price HoverBoard and HoverBoard Name \n");
		 
		 System.out.println(elementutil.getElement(sortOrder_HoverBoardName).getText());
		 System.out.println(elementutil.getElement(sortOrder_HoverBoardValue).getText());
		 
		return highvalue;
	}
		
	
}
