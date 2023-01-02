package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[normalize-space(@value)='Login']")
	WebElement btnLogin;
	
	
	@FindBy(xpath ="//div[contains(text(),'Warning')]")
	WebElement warningMessage;
	
	public void enterEmail(String emailID) {
		txtEmail.sendKeys(emailID);
	}
	public void enterPassword(String emailID) {
		txtPassword.sendKeys(emailID);
	}
	public void clickbtnLogin() {
		btnLogin.click();
	}
	public String isWarningMessage()   //Warning Message is displayed
	{
		return (warningMessage.getText());
		
	}
	

}
