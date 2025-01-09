package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountlogoutPage extends BasePage 
{
	//CONSTRUCTOR
	public AccountlogoutPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//LOCATORS
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement AccountlogoutPage_Continuebtn;
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement AccountlogoutPagetext;
	
	//ACTION METHODS
	public void clickAccountlogoutPage_Continuebtn()
	{
		AccountlogoutPage_Continuebtn.click();			
	}
	
	public boolean getAccountlogoutPagetext()
	{
		return (AccountlogoutPagetext.isDisplayed());
	}
}
