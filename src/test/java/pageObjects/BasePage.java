package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	//1. Create a constructor which will have the main driver and page factory class to be used by all the page object classes
	
	//local class driver declaration and creation
	WebDriver driver; 
	
	//Constructor - driver from child page object classes received as argument
	public BasePage(WebDriver driver) 
	{
		//assigning child class driver to parent class driver
		this.driver = driver; 
		//this assigns the driver to all the elements in the classes
		PageFactory.initElements(driver, this); 
		
	}

}
