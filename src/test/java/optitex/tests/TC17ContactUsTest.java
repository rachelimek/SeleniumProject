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

//doesn't work
//This test clicks on "contact us" icon, fills all information, clicks "continue" and verifies the message
@Epic("Pre sale")
@Feature("Contact us")
public class TC17ContactUsTest extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When clicking on 'contact us' and and filling the form, 'thank you' message should be displayed")
	@Test(description = "Contact us")
	@Description("Click on 'contact us' button, fill the opened form and reach to thank you message")
	public void contactUs() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.contactUs();
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		AllureAttachment.attachText("test!!!");
		contactUsPage.fillInfo("Maya", "Cohen", "111@gmail.com", "0528888888", "bbb", "Bags & Accessories", "Israel", "testing");
		String actual = contactUsPage.getMsg();
		String expected= "Thank you for contacting us, we will be in touch soon.";
		
		assertEquals(actual, expected);
	}
}
