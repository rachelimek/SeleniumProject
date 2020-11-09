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
import optitex.pageobjects.ThreeDPage;
import optitex.pageobjects.WebinarPage;
import optitex.utilities.AllureAttachment;

//This test clicks on search button, types 3D, choose first webinar result, clicks the webinar, fills the form and runs the video
@Epic("Search")
@Feature("Search Data")
public class TC03SearchWebinarTest extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When performing serach on 3D product and choosing a webinar including filling user info, the movie is running")
	@Test(description = "Search 3D webinar")
	@Description("click on search button, type 3D, choose first webinar , click the webinar, fills the form and run the video")
	public void searchWebinar() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.search("3D");
		ThreeDPage threeDPage = new ThreeDPage(driver);
		threeDPage.findWbinar("3D in Technical Textile Industry");
		WebinarPage webinarPage = new WebinarPage(driver);
		webinarPage.playVideo();
		webinarPage.fillForm("Aviv", "Lavi", "aviv@gmail.com", "0524444444", "aaa", "Apparel / Fashion / Sportswear", "Israel", "test");
		String actual = webinarPage.reachVideo();
		String expected = "Optitex Technical Textile Webinar Series – Session #6";
		AllureAttachment.attachText(actual);
		Assert.assertEquals(actual, expected);
		
	}
}
