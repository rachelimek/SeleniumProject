package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.AboutPage;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;

//This test clicks search by menu, scrolls down to about link, clicks on the link and reaches to about page
@Epic("Search")
@Feature("Search by menu")
public class TC05SearchByMenu extends BaseTest{
	@Severity(SeverityLevel.MINOR)
	@Story("When performing serach by menu and scrolling dwon, reaching to about page ")
	@Test(description = "Search link by menu")
	@Description("click search by menu, scroll down to about link, click on the link then about page is opened")
	public void searchAboutByMenu() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchByMenu();
		AboutPage aboutPage = new AboutPage(driver);
		String actual = aboutPage.aboutUpperHeader();
		String expected = "OPTITEX ABOUT";
		AllureAttachment.attachText(actual);
		assertEquals(actual, expected);
	}
}
