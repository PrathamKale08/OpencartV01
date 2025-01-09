package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC003_AccountRegistrationTest_UsingRandomUserData extends BaseClass
//TC_001 :Verify if new user can create an user account
{
	@Test(groups = {"Sanity","Master"})
	public void verify_AccountRegistrationTest()
	{
		HomePage hp = new HomePage(driver);
		hp.clickhomepage_myaccount();
		hp.clickhomepage_myaccount_register();
		
		RegisterAccountPage rap = new RegisterAccountPage(driver);
		rap.setAccountregistrationpage_firstname(randomString());
		rap.setAccountregistrationpage_lastname(randomString());
		rap.setAccountregistrationpage_email(randomString()+"@gmail.com");
		rap.setAccountregistration_inputtelephone(randomNumber());
		String password = randomAlphanumeric();
		rap.setAccountregistrationpage_password01(password);
		rap.setAccountregistrationpage_password02(password);
		rap.Accountregistrationpage_checkboxyesSubscribe();
		rap.clickAccountregistrationpage_checkboxPP();
		rap.clickAccountregistrationpage_buttonContinue();
		String confirmationmessage = rap.getAccountcreated_confirmationmessage();
		Assert.assertEquals(confirmationmessage, "Your Account Has Been Created!");	
	}
}
