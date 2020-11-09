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
import optitex.pageobjects.SupportPage;
import optitex.utilities.AllureAttachment;

//This test moves to Support menu, chooses "FAQ", scrolls down to "recommended system requirements", clicks on the link,  opens help on a new tab and verifies the result
@Epic("Support")
@Feature("FAQ")
public class TC18FaqLink extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When reaching 'FAQ' to 'recommended system requirements', help page is opened with Product System Requirements")
	@Test(description = "FAQ link")
	@Description("Move to support menu, choose FAQ, scroll down to 'recommended system requirements', click on the link and get help page with Product System Requirements")
	public void faqLink() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("FAQ");
		SupportPage supportPage = new SupportPage(driver);
		supportPage.chooseReqLink();
		HelpPage helpPage = new HelpPage(driver);
		String actual = helpPage.checkHeader();
		String expected = "Optitex Help Center";
		AllureAttachment.attachText(actual);
		assertEquals(actual, expected);
	}
}
