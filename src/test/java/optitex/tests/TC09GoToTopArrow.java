package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.MainPage;

//This test scrolls down to footer header, clicks on popup arrow, goes up to top of the window and verifies the window reached to the top 
@Epic("UX capabilities")
@Feature("Arrow")
public class TC09GoToTopArrow extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Story("When scrolling down, popup arrow is dispalyed. when clicking this arrow, the page goes up to the top of the page")
	@Test(description = "Scroll up arrow")
	@Description("Scroll down to footer header, click on popup arrow, go up to top of the window and verifies the window reached to the top")
	public void downAndUp() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.ScrollDownUp();
		String actual = mainPage.getIntroTitle();
		String expected = "DESIGN. DEVELOP. PRODUCE.";
		assertEquals(actual, expected);
	}
}
