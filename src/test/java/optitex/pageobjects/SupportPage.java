package optitex.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupportPage extends MainPage {
	@FindBy(css=".title.faq__title")
	public WebElement faqHeader;
	@FindBy(css=".faq__item:nth-child(3) a")
	public WebElement reqLink;
	
	
	public SupportPage(WebDriver driver) {
		super(driver);
	}
	
	//scroll down to FAQ and choose system requirements link
	public void chooseReqLink() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOf(faqHeader));
		sleep(2000);
		click(reqLink);
		SwitchSecondTab();
	}
	
}
