package optitex.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;

//This Test moves to Italian and verifies language change
@Epic("UX capabilities")
@Feature("Language change")
public class TC15ChangeLanguage extends BaseTest {
	@Severity(SeverityLevel.CRITICAL)
	@Story("When hovering English language, it os possible to move to another language")
	@Test(description = "Change language")
	@Description("Move to Italian and verify the language change")
	public void changeToItalian() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseLanguage("Italiano");
		String actual = mainPage.checkLanguage();
		String expected = "PROGETTA. SVILUPPA. PRODUCI.";
		AllureAttachment.attachText(actual);
		assertEquals(actual, expected);
	}
}
