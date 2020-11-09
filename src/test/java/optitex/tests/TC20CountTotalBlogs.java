package optitex.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.BlogPage;
import optitex.pageobjects.MainPage;
import optitex.utilities.AllureAttachment;

//This test scrolls down to Blog, open it on a different page, count number of blogs in each page and validate the total number of blogs
@Epic("Pre sale")
@Feature("Blog")
public class TC20CountTotalBlogs extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("When opening blog page, it is possible to move between the pages")
	@Test(description = "Total blogs count ")
	@Description("Scroll down to Blog, open it on a different page, count number of blogs in each page and validate the total number of blogs")
	public void countBlogs() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.openBlog();
		mainPage.SwitchSecondTab();
		BlogPage blogPage = new BlogPage(driver);
		assertTrue(blogPage.blogCounterAllPages() == 57);
	}
}
