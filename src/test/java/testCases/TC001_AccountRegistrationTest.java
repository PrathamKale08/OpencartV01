package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
//TC_001 :Verify if new user can create an user account
{
	@Test(groups = {"Sanity","Master"})
	public void verify_AccountRegistrationTest()
	{
		logger.info("*********** TC001_AccountRegistrationTest execution started ***********");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickhomepage_myaccount();
		logger.info("CLICKED ON MY ACCOUNT LINK");
		hp.clickhomepage_myaccount_register();
		logger.info("CLICKED ON REGISTER LINK");
		RegisterAccountPage rap = new RegisterAccountPage(driver);
		logger.info("ADDING USER DETAILS");
		rap.setAccountregistrationpage_firstname("Pratham");
		rap.setAccountregistrationpage_lastname("Kale");
		rap.setAccountregistrationpage_email("prathamkale400@gmail.com");
		rap.setAccountregistration_inputtelephone("9768476799");
		rap.setAccountregistrationpage_password01("prathamkale10@gmail.com");
		rap.setAccountregistrationpage_password02("prathamkale10@gmail.com");
		rap.Accountregistrationpage_checkboxyesSubscribe();
		rap.clickAccountregistrationpage_checkboxPP();
		rap.clickAccountregistrationpage_buttonContinue();
		logger.info("USER DETAILS ADDED");
		logger.info("PERFORMING VALIDATION OF ACCOUNT CREATION");
		String confirmationmessage = rap.getAccountcreated_confirmationmessage();
		
		if(confirmationmessage.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test case failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
			
		}
		//Assert.assertEquals(confirmationmessage, "Your Account Has Been Created!");	
		}
		catch(Exception e)
		{	
			Assert.fail();
		}
		
		logger.info("*********** TC001_AccountRegistrationTest execution finished ***********");
	}
}
