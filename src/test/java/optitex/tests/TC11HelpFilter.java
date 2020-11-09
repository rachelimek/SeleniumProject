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

//This test moves to Support menu, chooses Help, opens help on a new tab, clicks filter, marks PDS_2D and verifies filter icon is signed, un marks PDS_2D and verifies filter icon is deleted.
@Epic("Help")
@Feature("Help filter")
public class TC11HelpFilter extends BaseTest{
	@Severity(SeverityLevel.NORMAL)
	@Story("When filtering help option, filter icon is diplayed")
	@Test(priority = 1, description = "Filter help option")
	@Description("Move to support menu, choose Help, click filter, mark PDS_2D and verify filter icon")
	public void checkHelpFilterOn() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("Help");
		mainPage.SwitchSecondTab();
		HelpPage helpPage = new HelpPage(driver);
		helpPage.filterPds2D();
		assertTrue(helpPage.checkFilterIcon());
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Story("When unfiltering help option, filter icon is deleted")
	@Test(priority = 2, description = "UnFilter help option")
	@Description("Move to support menu, choose Help, unmark PDS_2D filtered option and verify filter icon is deleted")
	public void checkHelpFilterOff() throws InterruptedException {
		HelpPage helpPage = new HelpPage(driver);
		helpPage.unFilterPds2D();
		assertTrue(!helpPage.checkFilterIcon());
	}
}
