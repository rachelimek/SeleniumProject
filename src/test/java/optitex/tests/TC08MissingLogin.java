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

//This test moves to Support menu, chooses eLearning, opens eLearning in a new tab, scrolls down to "get started eLerning", clicks on this label and verifies the message
@Epic("eLearning")
@Feature("Login eLearning")
public class TC08MissingLogin extends BaseTest{
	@Severity(SeverityLevel.NORMAL)
	@Story("When entering eLearning application and clicking 'get started eLerning', login message is displayed")
	@Test(description = "No access")
	@Description("Move to support menu, choose eLearning, click on 'get started eLerning' and get login  message")
	public void getStarted() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("eLearning");
		mainPage.SwitchSecondTab();
		ElearningPage elearningPage = new ElearningPage(driver);
		elearningPage.openLink();
		String actual = elearningPage.getErrorMsg2();
		String expected = "You need to be logged in to access this page";
		assertEquals(actual, expected);

	}
}
