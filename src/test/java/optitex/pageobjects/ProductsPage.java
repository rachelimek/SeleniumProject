package optitex.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends GeneralActionsPage{
	@FindBy(css=".digital__service-item:nth-child(1)")
	private WebElement designLabel;
	@FindBy(css=".digital__service-item:nth-child(1) .digital__service-wrap .digital__point:nth-child(1) .digital__point-more")
	private WebElement ddiLabel;
	
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	//choose design section and move to 3DDI
	public void moveTo3ddi() throws InterruptedException {
		click(designLabel);
		sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
 		sleep(2000);
		click(ddiLabel);
 		
 		
	}



}
