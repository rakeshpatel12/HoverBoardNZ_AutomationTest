package com.qa.hover.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hover.base.BasePage;
import com.qa.hover.pages.CategoryLinkCheckPage3;
import com.qa.hover.pages.TaskPage1;
import com.qa.hover.pages.TaskPage2;
import com.qa.hover.util.ElementUtil;

public class CategoryLinkCheckPage3Test {

	WebDriver driver;	
	BasePage basepage;
	Properties prop;
	TaskPage1 taskpage1;
	TaskPage2 taskpage2;
	CategoryLinkCheckPage3 categorypage3;
	
	@BeforeMethod
	public void setUp() {
		
		basepage = new BasePage();
		prop=basepage.init_prop();
		driver = basepage.init_driver(prop);
		taskpage1 = new TaskPage1(driver);
		taskpage2 = taskpage1.gotoTaskPage2();
		categorypage3 = taskpage2.gotoCategoryLinkCheckPage3();
	}
	
	@Test(priority=1)
	public void LinkCheck_AllCategory() {
		categorypage3.allCategoryLinkCheck();
	}
	
	@Test(priority=2)
	public void linkCheck_10InchHoverBoardTest() {
		categorypage3.linkCheck_10InchHoverBoard();
	}
	
	@Test(priority=3)
	public void linkCheck_65InchHoverBoardTest() {
		categorypage3.linkCheck_65InchHoverBoard();
	}
	
	@Test(priority=4)
	public void linkCheck_HoverBoard8InchTest() {
		categorypage3.linkCheck_HoverBoard_8Inch();
	}
	
	@Test(priority=5)
	public void linkCheck_HoverBoard_OffRoad85Test() {
		categorypage3.linkCheck_HoverBoard_OffRoad85();
	}
	
	@Test(priority=6)
	public void linkCheck_HoverBoard_9InchTest() {
		categorypage3.linkCheck_HoverBoard_9Inch();
	}
	
	@Test(priority=7)
	public void linkCheck_AccessoriesTest() {
		categorypage3.linkCheck_Accessories();
	}
	
	@Test(priority=8)
	public void linkCheck_Adjustable_cartTest() {
		categorypage3.linkcheck_AdjustableCart();
	}
	
	@Test(priority=9)
	public void linkCheck_Hoverboard_BlackTest() {
		categorypage3.linkCheck_Hoverboard_Black();
	}
	
	@Test(priority=10)
	public void linkCheck_Hoverboard_BlueTest() {
		categorypage3.linkCheck_Hoverboard_Blue();
	}
	
	@Test(priority=11)
	public void linkCheck_Hoverboard_CheapTest() {
		categorypage3.linkCheck_Hoverboard_Cheap();
	}
	
	@Test(priority=12)
	public void linkCheck_Hoverboard_GoldTest() {
		categorypage3.linkCheck_Hoverboard_Gold();
	}
	@Test(priority=13)
	public void linkCheck_HoverBoard_ChargerTest() {
		categorypage3.linkCheck_HoverBoard_Charger();
	}
	@Test(priority=14)
	public void linkCheck_HoverBoard_HabdleBarTest() {
		categorypage3.linkCheck_HoverBoard_HabdleBar();
	}
	@Test(priority=15)
	public void linkCheck_HoverBoard_GraffitiTest() {
		categorypage3.linkCheck_HoverBoard_Graffiti();
		
	}
	
	@Test(priority=16)
	public void linkCheck_HoverBoard_RedTest() {
		categorypage3.linkCheck_HoverBoard_Red();
		
	}
	@Test(priority=17)
	public void linkCheck_SegwaysTest() {
		categorypage3.linkCheck_Segways();
		
	}
	@Test(priority=18)
	public void linkCheck_Self_Balancing_ScooterTest() {
		categorypage3.linkCheck_Self_Balancing_Scooter();
		
	}
	
	@Test(priority=19)
	public void linkCheck_HoverBoard_WhiteTest() {
		
		categorypage3.linkCheck_HoverBoard_White();
		
	}
	

	@AfterMethod
	void teardown(){
	driver.quit();	
	}
	
}
