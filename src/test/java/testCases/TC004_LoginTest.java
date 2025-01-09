package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC004_LoginTest extends BaseClass
{
	@Test(groups = {"Regression","Master"})
	public void verifytestlogin_validcredentials() throws IOException
	{	
		logger.info("TC004_LoginTest verification started");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickhomepage_myaccount();
		hp.clickhomepage_login();
		logger.info("Home page actions completed");
		LoginPage lp = new LoginPage(driver);
		lp.setloginpage_email(p.getProperty("email"));
		lp.setloginpage_password(p.getProperty("password"));
		lp.clickloginpage_loginbtn();
		logger.info("Login page actions completed");
		MyaccountPage map = new MyaccountPage(driver);
		boolean targetpage = map.isMyaccountpageexist();
		Assert.assertTrue(targetpage);		
		}
		catch(Exception e)
		{
			logger.error("Test case failed: " + e.getMessage(), e);
            Assert.fail("Exception occurred during login test.");
		}
		logger.info("TC004_LoginTest verification finished");
	}
}
