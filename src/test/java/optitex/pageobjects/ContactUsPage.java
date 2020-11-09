package optitex.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ContactUsPage extends GeneralActionsPage{
	@FindBy(css=".in-touch__right-inner [type=\"submit\"]")
	public WebElement continueBtn;
	@FindBy(css=".form-parsed__total-error.active")
	public WebElement missingErrorMsg;
	@FindBy(css=".row.in-touch__inner [name=\"incomingLead__firstName\"]")
	public WebElement firstNameField;
	@FindBy(css=".row.in-touch__inner [name=\"incomingLead__lastName\"]")
	public WebElement lastNameField;
	@FindBy(css=".row.in-touch__inner [name=\"incomingLead__email\"]")
	public WebElement emailField;
	@FindBy(css=".row.in-touch__inner [name=\"incomingLead__businessPhone\"]")
	public WebElement workPhoneField;
	@FindBy(css=".row.in-touch__inner [name=\"incomingLead_rawData__companyRaw\"]")
	public WebElement companyField;
//	@FindBy(css="span#select2-incomingLead_rawData__segmentRaw-im-container.select2-selection__rendered") //don't find collector 
	@FindBy(css=".selection #select2-incomingLead_rawData__segmentRaw-op-container")
	public WebElement marketSegmentField;
	@FindBy(css="#select2-incomingLead_rawData__countryRaw-6f-container")
	public WebElement countryField;
	@FindBy(css=".row.in-touch__inner [name=\"incomingLead_description\"]")
	public WebElement interestField;
	@FindBy(css=".form-parsed__thank-you--black.active")
	public WebElement successMsg;
	
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	//click continue without fill info
	public void missingFormInfo() throws InterruptedException {
		js.executeScript("window.scrollBy(0,1500)");
		sleep(500);
		click(continueBtn);
	}
	
	//check error message for missing data
	public String getMissingMsg() {
		return getText(missingErrorMsg);
	}
	
	//??? cannot find css locator for marketSegmentField
	//fill info and click continue
	@Step("Filling form with detailes: {firstname} {lastname} {email}")
	public void fillInfo(String firstName, String lastName, String email, String phone, String company, String marketSegment, String country, String interest) throws InterruptedException {
		js.executeScript("window.scrollBy(0,1000)");
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(emailField, email);
		fillText(workPhoneField, phone);
		fillText(companyField, company);
		selectByValue(marketSegmentField, marketSegment);
//		selectByValue(countryField, country);
		fillText(interestField, interest);
		sleep(500);
		click(continueBtn);
	}
	
	//contact success message 
	public String getMsg() {
		return getText(successMsg);
	}
}
