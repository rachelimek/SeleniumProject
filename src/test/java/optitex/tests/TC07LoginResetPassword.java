package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.ElearningPage;
import optitex.pageobjects.MainPage;

//This test moves to Support menu, chooses eLearning, opens eLearning in a new tab, opens login window, click on "forgot your password", enters email and check reset message 
@Epic("eLearning")
@Feature("Login eLearning")
public class TC07LoginResetPassword extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When entering eLearning application and prefroming reset password, reset message is displayed")
	@Test(description = "reset password")
	@Description("Move to support menu, choose eLearning, click on 'forgot your password', enters email and get reset message")
	public void resetPassword() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("eLearning");
		mainPage.SwitchSecondTab();
		ElearningPage elearningPage = new ElearningPage(driver);
		elearningPage.resetPassword("111@gmail.com");
		String actual = elearningPage.getResetMsg();
		String expected = "A password reset email has been sent to your email account. If you did not receive an email in your inbox, please check your spam filter.";
		assertEquals(actual, expected);
	}
}
