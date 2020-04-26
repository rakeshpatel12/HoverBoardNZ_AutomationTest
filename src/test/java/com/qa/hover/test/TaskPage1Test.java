package com.qa.hover.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hover.base.BasePage;
import com.qa.hover.pages.TaskPage1;

public class TaskPage1Test {
	
BasePage basepage;
Properties prop;
TaskPage1 taskpage1;
WebDriver driver;


@BeforeTest
public void setUp() {
	basepage = new BasePage();
	prop=basepage.init_prop();
	driver = basepage.init_driver(prop);
	taskpage1 = new TaskPage1(driver);
	
}

@Test(priority = 1)
public void SearchForHoverBoardtest() {
	String text = taskpage1.SearchForHoverBoard();
	//Checking label for Search - Hoverboard
	Assert.assertEquals(text, "Search - Hoverboard");
}

@Test(priority = 2)
public void printAllHoverBoardValueAndPriceTest() {
	String text = taskpage1.printAllHoverBoardValueAndPrice();
	//checking URL to page 2 and value 36
	//System.out.println(text.contains("https://hoverboardnz.co.nz/page/2/?count=36"));
	Assert.assertTrue(text.contains("https://hoverboardnz.co.nz/page/2/?count=36"));
	
}

@Test(priority = 3)
public void lowestValueHoverBoardNameTest() {
	String value = taskpage1.lowestValueHoverBoardName();
	Assert.assertEquals(value, "Sort by price: low to high");
}

@Test(priority = 4)
public void highestValueHoverBoardNameTest() {
	String value =  taskpage1.highestValueHoverBoardName();
	Assert.assertEquals(value, "Sort by price: high to low");
	
}
@AfterTest
public void tearDown() {
	driver.quit();
}

}
