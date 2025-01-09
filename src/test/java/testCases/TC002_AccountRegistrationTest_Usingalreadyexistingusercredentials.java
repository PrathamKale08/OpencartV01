package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC002_AccountRegistrationTest_Usingalreadyexistingusercredentials extends BaseClass
//TC_001 :Verify if user can create a new account with existing credentials
{	
	@Test(groups = {"Sanity","Master"})
	public void verify_ExistingAccountRegistrationTest()
	{
		HomePage hp = new HomePage(driver);
		hp.clickhomepage_myaccount();
		hp.clickhomepage_myaccount_register();
		
		RegisterAccountPage rap = new RegisterAccountPage(driver);
		rap.setAccountregistrationpage_firstname("Pratham");
		rap.setAccountregistrationpage_lastname("Kale");
		rap.setAccountregistrationpage_email("prathamkale@gmail.com");
		rap.setAccountregistration_inputtelephone("9768476798");
		rap.setAccountregistrationpage_password01("prathamkale@gmail.com");
		rap.setAccountregistrationpage_password02("prathamkale@gmail.com");
		rap.Accountregistrationpage_checkboxyesSubscribe();
		rap.clickAccountregistrationpage_checkboxPP();
		rap.clickAccountregistrationpage_buttonContinue();
		String existingaccountmessage = rap.getExistingaccount_confirmationmessage();
		Assert.assertEquals(existingaccountmessage, "Warning: E-Mail Address is already registered!");	
	}

}
