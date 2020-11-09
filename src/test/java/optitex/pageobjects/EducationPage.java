package optitex.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EducationPage extends BasePage {
	@FindBy(css=".TEST-CLASS li:nth-child(2)  .gallery__img-inner")
	public WebElement diorLabel;
//	@FindBy(css=".gallery__title")
		
	public EducationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
}
