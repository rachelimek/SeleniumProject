package optitex.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.HelpPage;
import optitex.pageobjects.MainPage;

//This test moves to Support menu, chooses Help, opens help on a new tab, clicks glossary, types "trim" and verify the result
@Epic("Help")
@Feature("Help glossery")
public class TC13HelpGlossary extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When using help glossary option, only filtered results are displayed")
	@Test(description = "Glossary term filter")
	@Description("Move to support menu, choose Help, click filter, mark glossary, types 'trim' and verify the result")
	public void glossaryFilter() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("Help");
		mainPage.SwitchSecondTab();
		HelpPage helpPage = new HelpPage(driver);
		helpPage.glossaryOfTrim("trim");
		String actual = helpPage.checkGlossary();
		String expected = "Trace and Trim";
		assertEquals(actual, expected);
	}
}