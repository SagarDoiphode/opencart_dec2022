package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups = {"Sanity", "Master"})
	public void Test_Login() {
		logger.info("Starting TC_002_LoginTest");
		try {
		logger.info("*** Landed to HomePage ****");
		//Login Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("*** Landed to LoginPage ****");
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(rb.getString("username"));
		lp.enterPassword(rb.getString("password"));
		lp.clickbtnLogin();
		logger.info("*** Landed to MyAccountPage ****");
		MyAccountPage mapTest = new MyAccountPage(driver);
		boolean targetPage = mapTest.isMyAccountPageExists();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		logger.info("************TC_002_LoginTest is finished **************");
	}

}
