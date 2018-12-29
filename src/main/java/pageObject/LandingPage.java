package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By login = By.xpath("//nav[@class='pull-right']/ul/li[4]/a/span");
	By title = By.xpath("//*[@id=\"content\"]/div/div/h2");
	By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
}
