package com.learn.acadamy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learn.frameworkfromscratch.Base;

import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends Base 
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver = intializeDriver();
		 log.info("driver is initialized");
		 
	}
	@AfterTest
	public void cleanup()
	{
		driver.close();
		driver=null;
	}
	
@Test(dataProvider="getData")	
public void onHomePage(String username, String password, String text) throws IOException
{
	driver.get(property.getProperty("url"));
	 LandingPage l = new LandingPage(driver);
	 l.getLogin().click();
	 LoginPage lp = new LoginPage(driver);
	 lp.getEmail().sendKeys(username);
	 lp.getPassword().sendKeys(password);
	 System.out.println(text);
	 log.info(text);
	 lp.getlogIn().click();
	
}

@DataProvider
public Object[][] getData()
{
	Object[][] data = new Object[2][3];
	data[0][0]="nonrestrcicted@gmail.com";
	data[0][1] = "12345";
	data[0][2] = "restricted user";
	
	data[1][0] = "restricteduser@gmail.com";
	data[1][1] = "098765";
	data[1][2] = "non restrcted users";
	
	return data;
}

@Test(enabled=false)
public void skipMethod()
{
	System.out.println("I have skipped this method");
}


@Test(enabled=false)
public void testFail()
{
	System.out.println("failing the method");
	driver.findElement(By.xpath("")).click();
}
}