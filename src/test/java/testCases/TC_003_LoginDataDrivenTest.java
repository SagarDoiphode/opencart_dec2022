package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"datadriven"})
	public void Test_Login(String uid, String pwd, String exp) {
		logger.info("Starting TC_003_LoginDataDrivenTest");

		logger.info("*** Landed to HomePage ****");
		// Login Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("*** Landed to LoginPage ****");
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(uid);
		lp.enterPassword(pwd);
		lp.clickbtnLogin();
		
		logger.info("*** Landed to MyAccountPage ****");
		MyAccountPage mapTest = new MyAccountPage(driver);
		boolean targetPage = mapTest.isMyAccountPageExists();
		if(exp.equals("Valid")) {
			  if(targetPage == true)
			    {
				mapTest.clickLogout();
				Assert.assertTrue(true);
	     		 } 
			  else {
	     			String actualMessage = lp.isWarningMessage();
	     			String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
	     			Assert.assertEquals(actualMessage, expectedMessage);
	     			Assert.assertTrue(false);
			    }
		}
		if (exp.equals("Invalid")) {
			if (targetPage == true) {
				MyAccountPage myaccpage = new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}


	}
}