package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage 
{
	//CONSTRUCTOR
	public MyaccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//LOCATOR
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement Myaccountheadertext;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Myaccountlogoutbtn;
	
	//ACTION METHOD
	public boolean isMyaccountpageexist()
	{
		try
		{
			return (Myaccountheadertext.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickMyaccountlogoutbtn()
	{
		Myaccountlogoutbtn.click();
	}
}
