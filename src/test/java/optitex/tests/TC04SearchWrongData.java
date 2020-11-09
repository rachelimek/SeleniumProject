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

//This test clicks on search button, types 4D (not exist), error message is displayed, type 5D and search again, same error is displayed
@Epic("Search")
@Feature("Search Data")
public class TC04SearchWrongData extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When performing serach on non exist data, error message is displayed")
	@Test(priority = 1, description = "Search wrong data")
	@Description("Click on search button, types 4D (not exist), error message is displayed, type 5D and search again, same error is displayed")
	public void searckInvalidData() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.search("4D");
		String actual = mainPage.searchInvalid();
		String expected = "Nothing Found";
		Assert.assertEquals(actual, expected);
		mainPage.innerSearch("5D");
		AllureAttachment.attachText(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Story("When performing a serach on exist data after a search on non-exist data, search is working")
	@Test(priority = 2, description = "Search exist data")
	@Description("After reaching 'Nothing Found', type 3D and reach to exists page")
	public void searckvalidData() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.innerSearch("3D");
		String actual = mainPage.validSearch();
		String expected = "3D";
		Assert.assertEquals(actual, expected);
	}
}
