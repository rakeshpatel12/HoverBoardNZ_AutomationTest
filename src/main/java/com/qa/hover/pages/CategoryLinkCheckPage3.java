package com.qa.hover.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hover.base.BasePage;
import com.qa.hover.util.ElementUtil;

public class CategoryLinkCheckPage3 extends BasePage{
	
	//check active link and broken link for all category
	WebDriver driver;
	ElementUtil elementutil;
	
	//By Locators
	//all product xpath
	By hoverboardproduct = By.xpath("//a[@class='product-loop-title']");
	//All category Xpath
	By allcategory = By.xpath("//div[@id='primary']/following::aside[1]/ul/li/a");
	
	By teninchhoverboard = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[1]/a"); 
	By hoverboard_65inch = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[2]/a");
	//By hoverboard65inchproduct = By.xpath("//a[@class='product-loop-title']");
	By hoverboard_8inch = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[3]/a");
	By hoverboard_offroad85 = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[4]/a");
	By hoverboard_9inch = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[5]/a");
	By accessories = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[6]/a");
	By adjustable_cart = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[7]/a");
	By hoverboard_black = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[8]/a");
	By hoverboard_blue = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[9]/a");
	By hoverboard_cheap = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[10]/a");
	By hoverboard_gold = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[11]/a");
	By hoverboard_charger = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[12]/a");
	By hoverboard_handlebar =By.xpath("//div[@id='primary']/following::aside[1]/ul/li[13]/a");
	By hoverboard_graffiti = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[14]/a");
	By hoverboard_red = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[15]/a");
	By segways = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[16]/a");
	By self_balancing_scooter = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[17]/a");
	By hoverboard_white = By.xpath("//div[@id='primary']/following::aside[1]/ul/li[18]/a");
	
	
	public CategoryLinkCheckPage3(WebDriver driver){
		this.driver=driver;
		elementutil = new ElementUtil(this.driver);
	}
	
	//ALl Category Link Check
	
	public void allCategoryLinkCheck() {
		elementutil.waitForElementPresent(allcategory);
		List<WebElement> list1 = elementutil.getElements(allcategory);
		System.out.println("Checking Links for All Category:" + list1.size());
		elementutil.getActiveLinks(list1);
			
		}
	
	
	
	
	
	
	//All collection link check
	/**
	 * Function to get all the elements and 
	 * check for active links
	 * @param category
	 * @param product
	 */
	
	public void linkCheck(By category, By product) {
		elementutil.waitForElementPresent(category);
		elementutil.doClick(category);
		elementutil.waitForElementPresent(product);
		List<WebElement> list1 = elementutil.getElements(product);
		System.out.println("\n Checking Links for "+ elementutil.getElement(category).getText()+
				" total product "+ list1.size());
		System.out.println("--------------------------------------------------------------------");
		elementutil.getActiveLinks(list1);		
	}
	
	public void linkCheck_10InchHoverBoard() {
		linkCheck(teninchhoverboard, hoverboardproduct);

	}
	
	public void linkCheck_65InchHoverBoard() {
		linkCheck(hoverboard_65inch, hoverboardproduct);
	}

	public void linkCheck_HoverBoard_8Inch() {
		linkCheck(hoverboard_8inch, hoverboardproduct);

	}

	public void linkCheck_HoverBoard_OffRoad85() {

		linkCheck(hoverboard_offroad85, hoverboardproduct);

	}

	public void linkCheck_HoverBoard_9Inch() {
		linkCheck(hoverboard_9inch, hoverboardproduct);

	}

	public void linkCheck_Accessories() {
		linkCheck(accessories, hoverboardproduct);

	}

	public void linkcheck_AdjustableCart() {
		linkCheck(adjustable_cart, hoverboardproduct);
	}

	public void linkCheck_Hoverboard_Black() {
		linkCheck(hoverboard_black, hoverboardproduct);

	}

	public void linkCheck_Hoverboard_Blue() {
		linkCheck(hoverboard_blue, hoverboardproduct);

	}

	public void linkCheck_Hoverboard_Cheap() {
		linkCheck(hoverboard_cheap, hoverboardproduct);
	}

	public void linkCheck_Hoverboard_Gold() {
		linkCheck(hoverboard_gold, hoverboardproduct);

	}

	public void linkCheck_HoverBoard_Charger() {
		linkCheck(hoverboard_charger, hoverboardproduct);
	}

	public void linkCheck_HoverBoard_HabdleBar() {
		linkCheck(hoverboard_handlebar, hoverboardproduct);
	}

	public void linkCheck_HoverBoard_Graffiti() {
		linkCheck(hoverboard_graffiti, hoverboardproduct);
	}

	public void linkCheck_HoverBoard_Red() {
		linkCheck(hoverboard_red, hoverboardproduct);
	}

	public void linkCheck_Segways() {
		linkCheck(segways, hoverboardproduct);
	}

	public void linkCheck_Self_Balancing_Scooter() {
		elementutil.scrollByPixel();
		linkCheck(self_balancing_scooter, hoverboardproduct);
	}

	public void linkCheck_HoverBoard_White() {
		elementutil.scrollByPixel();
		linkCheck(hoverboard_white, hoverboardproduct);
	}
}
