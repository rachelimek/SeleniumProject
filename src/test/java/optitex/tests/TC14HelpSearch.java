package optitex.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.HelpPage;
import optitex.pageobjects.MainPage;

//This test moves to Support menu, chooses Help, opens help on a new tab, clicks search, type "trim" value and verifies the found results are for "trim"
@Epic("Help")
@Feature("Help search")
public class TC14HelpSearch extends BaseTest {
	@Severity(SeverityLevel.CRITICAL)
	@Story("When using help search option, only filtered results are displayed")
	@Test(description = "Search filter")
	@Description("Move to support menu, choose Help, click search, type 'trim' value and verify the found results are for 'trim'")
	public void searchText() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("Help");
		mainPage.SwitchSecondTab();
		HelpPage helpPage = new HelpPage(driver);
		helpPage.searchTrim("trim");
		assertTrue(helpPage.checkSreach("trim"));
		
	}
}
