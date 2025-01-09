package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage
{
	//1. CONSTRUCTOR
	public RegisterAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//2. LOCATORS FOR ALL THE ELEMENTS OF REGISTRATION PAGE
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement Accountregistrationpage_inputfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Accountregistrationpage_inputlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Accountregistrationpage_inputemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Accountregistration_inputtelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Accountregistrationpage_inputpassword01;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement Accountregistrationpage_inputpassword02;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement Accountregistrationpage_checkboxyesSubscribe;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Accountregistrationpage_checkboxPP;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Accountregistrationpage_buttonContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Accountcreated_confirmationmessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement Existingaccount_confirmationmessage;
	
	//3. ACTION METHODS FOR ALL THE ELEMENTS OF REGISTRATION PAGE
	public void setAccountregistrationpage_firstname(String firstname)
	{
		Accountregistrationpage_inputfirstname.sendKeys(firstname);
	}
	
	public void setAccountregistrationpage_lastname(String lastname)
	{
		Accountregistrationpage_inputlastname.sendKeys(lastname);
	}
	
	public void setAccountregistrationpage_email(String email)
	{
		Accountregistrationpage_inputemail.sendKeys(email);
	}
	
	public void setAccountregistration_inputtelephone(String telephone)
	{
		Accountregistration_inputtelephone.sendKeys(telephone);
	}
	
	public void setAccountregistrationpage_password01(String password)
	{
		Accountregistrationpage_inputpassword01.sendKeys(password);
	}
	
	public void setAccountregistrationpage_password02(String password)
	{
		Accountregistrationpage_inputpassword02.sendKeys(password);
	}
	
	public void Accountregistrationpage_checkboxyesSubscribe()
	{
		Accountregistrationpage_checkboxyesSubscribe.click();
	}
	
	public void clickAccountregistrationpage_checkboxPP()
	{
		Accountregistrationpage_checkboxPP.click();
	}
	
	public void clickAccountregistrationpage_buttonContinue()
	{
		Accountregistrationpage_buttonContinue.click();
	}
	
	public String getAccountcreated_confirmationmessage()
	//return type is string because the text message will be in string type
	{
		try
		{
			return(Accountcreated_confirmationmessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	public String getExistingaccount_confirmationmessage()
	{
		try
		{
			return(Existingaccount_confirmationmessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
	}
	
	
}
