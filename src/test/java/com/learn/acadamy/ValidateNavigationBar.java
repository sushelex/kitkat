package com.learn.acadamy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learn.frameworkfromscratch.Base;

import pageObject.LandingPage;


public class ValidateNavigationBar extends Base 
{
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
		driver.get(property.getProperty("url"));
	}
	@Test	
	public void ValidatingNavigationbar() throws IOException
	{
		driver.get(property.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("navigation assertion is done");

	}

	@AfterTest
	public void cleanup()
	{
		driver.close();
		driver=null;
	}

}

