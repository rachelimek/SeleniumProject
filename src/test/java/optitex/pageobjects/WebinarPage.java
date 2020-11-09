package optitex.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class WebinarPage extends GeneralActionsPage {
	@FindBy(css="#animate-video-play")
	private WebElement playVideoBtn;
	@FindBy(css=".popup__inner.ps.ps--active-y .form-row:nth-child(1) [type=\"text\"]") 
	public WebElement firstNameField;
	@FindBy(css=".popup__inner.ps.ps--active-y .form-row:nth-child(2) [type=\"text\"]")
	public WebElement lastNameField;
	@FindBy(css=".popup__inner.ps.ps--active-y .form-row [type=\"email\"]")
	public WebElement emailField;
	@FindBy(css=".popup__inner.ps.ps--active-y .form-row:nth-child(4) [type=\"text\"]")
	public WebElement phoneField;
	@FindBy(css=".popup__inner.ps.ps--active-y .form-row:nth-child(5) [type=\"text\"]")
	public WebElement companyField;
	@FindBy(css="#select2-incomingLead_rawData__segmentRaw-7r-container")
	public WebElement marketSegmentField;
	@FindBy(css="#select2-incomingLead_rawData__countryRaw-ou-container")
	public WebElement countryField;
	@FindBy(css=".popup__inner.ps.ps--active-y [name=\"incomingLead_description\"]")
	public WebElement interestField;
	@FindBy(css=".popup__inner.ps.ps--active-y [type=\"submit\"]")
	public WebElement continueBtn;
	@FindBy(css="[title=\"YouTube video player\"]")
	public WebElement frame;
	@FindBy(css=".ytp-title-link.yt-uix-sessionlink")
	public WebElement checkVideo;
	
	
	public WebinarPage(WebDriver driver) {
		super(driver);
	}
	
	public void playVideo() {
		click(playVideoBtn);
	}
	
	//fill the form with all information
	@Step("Filling form with detailes: {firstname} {lastname} {email}")
	public void fillForm(String firstname, String lastname, String email, String phone, String company, String segment, String country, String interest) {
		fillText(firstNameField, firstname);
		fillText(lastNameField, lastname);
		fillText(emailField, email);
		fillText(phoneField, phone);
		fillText(companyField, company);
//		selectByValue(marketSegmentField, segment);
//		selectByValue(countryField, country);
		fillText(interestField, interest);
		click(continueBtn);
	}
	
	//reach to video and execute it
	public String reachVideo() {
		getFrame(frame);
		return getText(checkVideo);
	}
	
}
