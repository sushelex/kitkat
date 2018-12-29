package com.learn.frameworkfromscratch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver driver;
	public Properties property;
	public WebDriver intializeDriver() throws IOException
	{
		//chrome>>invoke chrome browser
		//IE
		//Firefox
		property = new Properties();
		FileInputStream fin = new FileInputStream("D:\\automation\\frameworkstart\\src\\main\\java\\resources\\data.properties");
		property.load(fin);
		String browser = property.getProperty("chrome");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		else if(browser.equals("Internet Explorar"))
		{
			System.setProperty("webdriver.edge.driver", "E:\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scc, );
		FileUtils.copyFile(src, new File("D://automation//frameworkstart//screenshots//"+result+"screenshot.png"));
		
	}
}

