package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups = {"Sanity", "Regression", "Master"})
	public void Test_Account_Regsitration() {
		try {
			logger.info("***TC_001_AccountRegistrationTest has started********** ");
			HomePage hp = new HomePage(driver);
			logger.info("User is clicking on the Account");
			hp.clickMyAccount();
			logger.info("User is clicking on the Register");
			hp.clickRegister();
			logger.info("User moved to Registration Page");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");
			regpage.setTelephone(randomeNumber());
			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			// regpage.getConfirmationMsg();
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created1!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}

	}
}
