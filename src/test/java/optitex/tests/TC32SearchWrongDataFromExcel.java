package optitex.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;
import optitex.utilities.Excel;

@Epic("Search")
@Feature("Search Data")
public class TC32SearchWrongDataFromExcel extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When performing serach on non exist data, error message is displayed")
	@Test(dataProvider = "getDataFromExcel", description = "Search wrong data")
	@Description("Click on search button, get non exist data from external excel and recieve error message")

//	@Test(dataProvider = "getDataFromExcel")
	public void searckInvalidData(String value) throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.search(value);
		String actual = mainPage.searchInvalid();
		String expected = "Nothing Found";
		AllureAttachment.attachText(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\optitex\\data\\search.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "search1");
		return table;
	
	}
}