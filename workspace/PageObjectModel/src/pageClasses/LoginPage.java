package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id= "username")
	WebElement txtUsername;
	
	@FindBy(id= "password")
	WebElement txtPassword;
	
	@FindBy(id= "login")
	WebElement btnlogin;
	
	@FindBy(xpath = "//div/b[text() = 'Invalid Login Details']")
	WebElement txtInvalidLogin;
	
	public LoginPage() {
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	public WebElement getTextUsername() {
		return txtUsername;
	}
	
	public WebElement getTextPassword() {
		return txtPassword;
	}
	
	public WebElement getBtnLogin() {
		return btnlogin;
		}
	
	public String getTextInvalidLogin() {
		return txtInvalidLogin.getText();
		}
	
	public void setTextUsername(String value) {
		txtUsername.clear();
		txtUsername.sendKeys(value);
	}
	
	public void setTextPassword(String value) {
		txtPassword.clear();
		txtPassword.sendKeys(value);
	}
	
	public void setBtnlogin() {
		btnlogin.click();
		
	}
	
	
	private void txtInvalidLogin() {
		// TODO Auto-generated method stub
		
	}
	}