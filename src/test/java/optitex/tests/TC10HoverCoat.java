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

//This test hovers the coat's top point and verifies the label, hovers on coat's lower point and verifies the label
@Epic("UX capabilities")
@Feature("Hovering")
public class TC10HoverCoat extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Story("When hovering the coat point, explanation label is displayed")
	@Test(description = "Hovering coat")
	@Description("Hover the coat's top point and verify the label, hover on coat's lower point and verify the label")
	public void hoverCoatPoints() {
		MainPage mainPage = new MainPage(driver);
		mainPage.hoverCoatTop();
		String actual = mainPage.getHoverCoatTop();
		String expected = "Rich fabric library";
		assertEquals(actual, expected);
		mainPage.hoverCoatBottom();
		actual = mainPage.getHoverCoatbottom();
		expected = "Advanced 3D prototyping";
		assertEquals(actual, expected);
	}
}
