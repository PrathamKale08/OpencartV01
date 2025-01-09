package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountlogoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC005_LoginTest_DataProvider extends BaseClass
{
	@Test(dataProvider = "logindp01",groups = {"datadriven","Master"})
	public void verifytestlogin_validcredentials(String email,String password) throws IOException, InterruptedException
	{	
		logger.info("TC005_LoginTest using Data provider verification started");
		
		HomePage hp = new HomePage(driver);
		hp.clickhomepage_myaccount();
		hp.clickhomepage_login();
		logger.info("Home page actions completed");
		
		LoginPage lp = new LoginPage(driver);
		lp.setloginpage_email(email);
		lp.setloginpage_password(password);
		lp.clickloginpage_loginbtn();
		logger.info("Login page actions completed");
		
		MyaccountPage map =new MyaccountPage(driver);
		map.clickMyaccountlogoutbtn();
		logger.info("My acccount page actions completed");
		
		logger.info("Credentials verification started");
		AccountlogoutPage alp = new AccountlogoutPage(driver);
		boolean logoutpagetext = alp.getAccountlogoutPagetext();
		if(logoutpagetext=true)
		{
			alp.clickAccountlogoutPage_Continuebtn();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		logger.info("Account logout page actions completed");
		
		
		logger.info("TC004_LoginTest verification finished");
	}
	
	@DataProvider(name="logindp01")
	Object[][] logindata()
	{
		Object data[][] = {
							{"goku@gmail.com","goku@gmail.com"},
							{"001@gmail.com","goku@gmail.com"},
							{"Pratham@gmail.com","goku@gmail.com"},
							{"Vandana@gmail.com","goku@gmail.com"},
							{"Priyanka@gmail.com","goku@gmail.com"},
							{"Pravinkale@gmail.com","goku@gmail.com"},	
						  };
		return data;
	}
	
	
}
