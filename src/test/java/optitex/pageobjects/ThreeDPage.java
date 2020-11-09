package optitex.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThreeDPage extends GeneralActionsPage{
	@FindBy(css=".entry-title")
	private List<WebElement> searchResults;
	
	
	public ThreeDPage(WebDriver driver) {
		super(driver);
	}
	
	public void findWbinar(String webinar) {
		for (WebElement element : searchResults) {
			if (getText(element).contains(webinar)) {
				click(element);
				break;
			}
		}
		
	}
}
