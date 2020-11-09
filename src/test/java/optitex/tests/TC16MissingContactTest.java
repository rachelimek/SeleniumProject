package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.ContactUsPage;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;

//This test clicks on "contact us", moves to "contact us" page, clicks continue without filling info and verifies error message
@Epic("Pre sale")
@Feature("Contact us")
public class TC16MissingContactTest extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When clicking on 'contact us' and continue without filling the form, missing info message should be displayed")
	@Test(description = "Contact us missing details")
	@Description("Click on 'contact us' button, press continue without filling form and get error message message")
	public void MissingContactData() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.contactUs();
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		contactUsPage.missingFormInfo();
		String actual = contactUsPage.getMissingMsg();
		String expected = "Some fields are missing";
		AllureAttachment.attachText(actual);
		assertEquals(actual, expected);
		
	}
}
