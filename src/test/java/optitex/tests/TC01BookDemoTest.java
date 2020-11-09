package optitex.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;


//This test clicks on "book a demo" button, fills the opened form and reach to thank you message 
@Epic("Pre sale")
@Feature("Book a demo")
public class TC01BookDemoTest extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When clicking on 'book a demo' and continue without filling the form, missing info message should be displayed")
	@Test(priority = 1, description = "Book a demo missing details")
	@Description("Click on 'book a demo' button, press continue without filling form and get error message message")
	public void bookDemoWithoutInfo() {
		MainPage mainPage = new MainPage(driver);
		mainPage.bookDemo();
		mainPage.noFillForm();
		String actual = mainPage.checkErrorMsg();
		String expected = "Some fields are missing";
		AllureAttachment.attachText(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Story("When clicking on 'book a demo' and filling the form, 'thank you' message should be displayed")
	@Test(priority = 2, description = "Book a demo")
	@Description("Click on 'book a demo' button, fill the opened form and reach to thank you message")
	public void bookDemo() {
		MainPage mainPage = new MainPage(driver);
		mainPage.fillForm("Aviv", "Lavi", "aviv@gmail.com", "0524444444", "aaa", "Apparel / Fashion / Sportswear", "Israel", "test");
		String actual = mainPage.checkMsg();
		String expected = "Thank you for contacting us, we will be in touch soon.";
		AllureAttachment.attachText(actual);
		Assert.assertEquals(actual, expected);
	}
}
