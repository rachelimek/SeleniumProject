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

//This test moves to Support menu, chooses eLearning, opens eLearning on a new tab, enters wrong user info, clicks login and checks error message
@Epic("eLearning")
@Feature("Login eLearning")
public class TC06LoginWrongUser extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When entering eLearning application with wrong user, error message is displayed")
	@Test(description = "Login with wrong username")
	@Description("Move to support menu, choose eLearning, enter wrong user info and get error login message ")
	public void loginElearningWrongUser() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("eLearning");
		mainPage.SwitchSecondTab();
		ElearningPage elearningPage = new ElearningPage(driver);
		elearningPage.fillLogin("111@gmail.com", "3333");
		String actual = elearningPage.getErrorMsg();
		String expected = "Your username or password is incorrect. Please try again, making sure that CAPS LOCK key is off.";
//		AllureAttachment.attachText(actual);
		assertEquals(actual, expected);
	}
}
