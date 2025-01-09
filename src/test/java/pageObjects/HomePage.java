package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage
{
	/*PageObject class consists of
	 * 1. Constructor for the driver
	 * 2. Element Locators
	 * 3. Action methods
	 */
	
	//1. CONSTRUCTOR
	public HomePage(WebDriver driver)
	{
		//passing driver from child class to parent class constructor
		super(driver); 
	}
	
	//2. LOCATORS
	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement homepage_myaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement homepage_myaccount_register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement homepage_login;
	
	//3. ACTION METHODS
	public void clickhomepage_myaccount()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(homepage_myaccount));
	    homepage_myaccount.click();
	}
	
	public void clickhomepage_myaccount_register()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(homepage_myaccount_register));
	    homepage_myaccount_register.click();
	}
	
	public void clickhomepage_login()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(homepage_login));
	    homepage_login.click();
	}
}
