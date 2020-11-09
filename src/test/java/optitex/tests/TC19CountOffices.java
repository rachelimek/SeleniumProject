package optitex.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.AboutPage;
import optitex.pageobjects.MainPage;

//This test hovers "about" menu, chooses "company" option, scrolls down to offices section, counts number of offices and verify this number
@Epic("Pre sale")
@Feature("About us")
public class TC19CountOffices extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Story("When reaching to 'about us', list of company offices will be displayed")
	@Test(description = "Count number of offices")
	@Description("Move to about menu, choose company, scroll down to offices section, counts number of offices and verify this number")
	public void countOfficeNum() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("About");
		mainPage.chooseCompany();
		AboutPage aboutPage= new AboutPage(driver);
		assertTrue(aboutPage.getOfficesNumber() == 6);
	}
}
