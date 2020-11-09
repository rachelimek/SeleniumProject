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

//This test moves to Support menu, chooses Help, opens help on a new tab, clicks index, fills "PDS" and verifies number of returned results is 2
@Epic("Help")
@Feature("Help index")
public class TC12HelpIndex extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When using help index option, only filtered results are displayed")
	@Test(description = "Index filter")
	@Description("Move to support menu, choose Help, click index, fill 'PDS' and verify number of returned results")
	public void checkHelpIndex() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("Help");
		mainPage.SwitchSecondTab();
		HelpPage helpPage = new HelpPage(driver);
		helpPage.indexPDS("PDS");
		assertTrue(helpPage.getIndexResult() == 2);
	}
}
