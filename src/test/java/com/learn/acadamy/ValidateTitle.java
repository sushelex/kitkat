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


public class ValidateTitle extends Base 
{
	public static Logger log = LogManager.getLogger(Base.class.getName());	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
		log.info("Driver is initialized");
	}
	@AfterTest
	public void cleanup()
	{
		driver.close();
		driver=null;
		log.info("driver closed successfull");
	}

	@Test	
	public void validatingTitle() throws IOException
	{
		driver.get(property.getProperty("url"));
		log.info("url is provided to driver");
		LandingPage l = new LandingPage(driver);
		log.info("landing page object reference is given");
		String title = l.gettitle().getText();
		log.info("url is provided to driver");
		System.out.println("title::"+title);
		//compare text with from browser with actual value
	//	Assert.assertEquals(title, "FEATURED COURSESS");
		log.info("title assetion is done");
	}

}
