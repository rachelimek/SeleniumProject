package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import optitex.pageobjects.ElearningPage;
import optitex.pageobjects.MainPage;

public class test extends BaseTest {
	@Test
	public void loginElearningWrongUser() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseSupportMenu("Support");
		mainPage.chooseElearningMenu("eLearning");
		mainPage.SwitchSecondTab();
	
	}
}
