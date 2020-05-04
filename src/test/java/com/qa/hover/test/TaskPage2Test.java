package com.qa.hover.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hover.base.BasePage;
import com.qa.hover.pages.TaskPage1;
import com.qa.hover.pages.TaskPage2;

public class TaskPage2Test {
	BasePage basepage;
	Properties prop;
	TaskPage1 taskpage1;
	TaskPage2 taskpage2;
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		
		basepage = new BasePage();
		prop=basepage.init_prop();
		driver = basepage.init_driver(prop);
		taskpage1 = new TaskPage1(driver);
		taskpage2 = taskpage1.gotoTaskPage2();
	}
	
	@Test
	public void test1() {
		String s1 =taskpage2.checkAllActiveLinks();
		System.out.println(s1);
		Assert.assertEquals(s1, "CATEGORIES");
		
		
	}
	
	@AfterTest
	void teardown(){
	driver.quit();	
	}
	
}
