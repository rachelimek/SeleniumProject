package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.ElearningPage;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;
import optitex.utilities.Excel;

//This test receives input from excel for username and password 
//This test opens eLearning page, enters wrong user info, clicks login and checks error message
@Epic("eLearning")
@Feature("Login eLearning")
public class TC31LoginWrongUserFromExcel extends BaseTest{
	@Severity(SeverityLevel.NORMAL)
	@Story("When entering eLearning application with wrong user, error message is displayed")
	@Test(dataProvider = "getDataFromExcel", description = "Login with wrong username")
	@Description("Move to support menu, choose eLearning, get wrong user info from external excel and get error login message ")
	public void loginElearningWrongUser(String username, String password) throws InterruptedException {
		driver.get("https://learn.optitex.com/index");
//		MainPage mainPage = new MainPage(driver);
//		mainPage.chooseSupportMenu("Support");
//		mainPage.chooseElearningMenu("eLearning");
//		mainPage.SwitchSecondTab();
		ElearningPage elearningPage = new ElearningPage(driver);
		elearningPage.fillLogin(username, password);
		String actual = elearningPage.getErrorMsg();
		String expected = "Your username or password is incorrect. Please try again, making sure that CAPS LOCK key is off.";
		AllureAttachment.attachText(actual);
		assertEquals(actual, expected);
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		Object[][] myData = {
//				{"user1", "1111"},
//				{"user2", "2222"},
//				{"user3", "3333"},
//				{"user4", "4444"},
//				{"user5", "5555"},
//				
//		};
//		return myData;
//	}
	
	@DataProvider
	public Object[][] getDataFromExcel() {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\optitex\\data\\login.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "login1");
		return table;
	
	}
	
}

