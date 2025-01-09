package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	//CONSTRUCTOR
	public LoginPage(WebDriver driver)
	{
		super(driver);	
	}
	
	//LOCATORS
	@FindBy(xpath="//input[@id='input-email']")
	WebElement loginpage_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement loginpage_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginpage_loginbtn;
	
	//ACTION METHODS
	public void setloginpage_email(String email)
	{
		loginpage_email.sendKeys(email);
	}
	
	public void setloginpage_password(String password)
	{
		loginpage_password.sendKeys(password);
	}
	
	public void clickloginpage_loginbtn()
	{
		loginpage_loginbtn.click();
	}
	

}
