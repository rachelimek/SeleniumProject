package optitex.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AboutPage extends GeneralActionsPage {
	@FindBy(css=".welcome__header-l")
	private WebElement aboutHeader;
	@FindBy(css=".title.offices__title")
	private WebElement officesMainTitle;
	@FindBy(css=".offices__name")
	private List<WebElement> officeTitle;
	
	public AboutPage(WebDriver driver) {
		super(driver);
	}
	
	//validation - find about header
	public String aboutUpperHeader() {
		return getText(aboutHeader);
	}
	
	//validation - count number of offices
	public long getOfficesNumber() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOf(officesMainTitle));
		scrollTo(officesMainTitle);
		long counter = 0;
		for (int i = 0; i < officeTitle.size(); i++) {
			counter = i + 1;
		}
		return counter;
	}
}
