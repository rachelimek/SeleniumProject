package optitex.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import optitex.pageobjects.DiPage;
import optitex.pageobjects.MainPage;
import optitex.pageobjects.ProductsPage;

//This test clicks on "explore our products" button, clicks on all products, clicks on 3D design illustrator and runs the movie
@Epic("Products")
@Feature("3D design illustrator")
public class TC02WatchVideoTest extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Story("When clicking on 'explore our products' button, clicking on all products, clicking on 3D design illustrator then a movie is running")
	@Test(description = "Execute a movie")
	@Description("Choose on 3DDI from all products and run the movie")
	public void diProductMovie() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.exploreProducts();
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.moveTo3ddi();
		DiPage diPage = new DiPage(driver);
		diPage.watchVideo();
		String actual = diPage.checkVedioOn();
		String expected= "Optitex 3D Design for Illustrator - Instantly view your designs in 3D - all in Adobe Illustrator";
		assertEquals(actual, expected);
		
	}
	
	
}
