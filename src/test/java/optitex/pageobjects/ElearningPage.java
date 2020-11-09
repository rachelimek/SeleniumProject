package optitex.pageobjects;

import javax.swing.Box.Filler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ElearningPage extends GeneralActionsPage{
	@FindBy(css=".icon-signin")
	public WebElement loginMenu;
	@FindBy(css="#tl-shared-username")
	public WebElement usernameField;
	@FindBy(css="[type=\"password\"]")
	public WebElement passwordField;
	@FindBy(css="#tl-cms-login-form [type=\"submit\"]")
	public WebElement loginBtn;
	@FindBy(css=".toast-message")
	public WebElement errorMsg;
	@FindBy(css=".control-group .link-color")
	public WebElement forgotPasswordLink;
	@FindBy(css=".spacer [name=\"username\"]")
	public WebElement resetField;
	@FindBy(css="#tl-cms-forgot-password-form [type=\"submit\"]")
	public WebElement sendBtn;
	@FindBy(css=".toast-message") 
	public WebElement successMsg;
	@FindBy(css=".tl-cms-course-wrapper.tl-cursor-pointer:nth-child(1)")
	public WebElement getStartedIcon;
	@FindBy(css=".tl-body .toast.toast-error .toast-message")
	public WebElement loginErrorMsg;
	
	public ElearningPage(WebDriver driver) {
		super(driver);
	}
	
	//click on login eLearning, fill login info and click login
	@Step("Filling form with detailes: {username} {password}")
	public void fillLogin(String username, String password) throws InterruptedException {
		click(loginMenu);
		sleep(1000);
		fillText(usernameField, username);
		fillText(passwordField, password);
		click(loginBtn);
		sleep(500);
	}
	
	//validation - get error message for wrong login info
	public String getErrorMsg() {
		return getText(errorMsg);
	}
	
	//click on login eLearning, click on reset password, fill email and click send
	public void resetPassword(String username) throws InterruptedException {
		click(loginMenu);
		sleep(1000);
		click(forgotPasswordLink);
		fillText(resetField, username);
		click(sendBtn);
	}
	
	//validation - get reset password message
	public String getResetMsg() {
		wait.until(ExpectedConditions.textToBePresentInElement(successMsg, "A password reset email has been sent to your email account. If you did not receive an email in your inbox, please check your spam filter."));
		return getText(successMsg);
	}
	
	//Open "Get Started" icon
	public void openLink() throws InterruptedException {
		scrollTo(getStartedIcon);
		sleep(500);
		click(getStartedIcon);
	}
	
	//validation - get error message for missing login
	public String getErrorMsg2() {
		return getText(loginErrorMsg);
	}
}
