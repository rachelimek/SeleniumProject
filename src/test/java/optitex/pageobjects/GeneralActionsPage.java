package optitex.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class GeneralActionsPage extends BasePage {
	@FindBy(css="#nav-menu-item-14956>.menu-link.main-menu-link")
	public WebElement bookDemoBtn;
	@FindBy(css="#book_a_demo_popup_formular .form-row:nth-child(1) [type=\"text\"]") 
	public WebElement firstNameField;
	@FindBy(css="#book_a_demo_popup_formular .form-row:nth-child(2) [type=\"text\"]")
	public WebElement lastNameField;
	@FindBy(css="#book_a_demo_popup_formular .form-row [type=\"email\"]")
	public WebElement emailField;
	@FindBy(css="#book_a_demo_popup_formular .form-row:nth-child(4) [type=\"text\"]")
	public WebElement phoneField;
	@FindBy(css="#book_a_demo_popup_formular .form-row:nth-child(5) [type=\"text\"]")
	public WebElement companyField;
	@FindBy(css="[data-select2-id=\"7\"] ")
	public WebElement marketSegmentField;
	@FindBy(css="#select2-incomingLead_rawData__countryRaw-ou-container")
	public WebElement countryField;
	@FindBy(css="#book_a_demo_popup_formular [name=\"incomingLead_description\"]")
	public WebElement interestField;
	@FindBy(css="#book_a_demo_popup_formular [type=\"submit\"]")
	public WebElement continueBtn;
	@FindBy(css=".popup__inner.ps .form-parsed__thank-you.form-parsed__thank-you.active")
	public WebElement contactMsg;
	@FindBy(css="#footer_popup_formular .popup__close")
	public WebElement xLabel;
	@FindBy(css=".main-nav__logo")
	public WebElement mainLogo;
	@FindBy(css=".form-parsed__total-error.active")
	public WebElement errorMsg;
	@FindBy(css=".main-nav__search")
	public WebElement searchBtn;
	@FindBy(css=".search__result")
	public WebElement searchField;
	@FindBy(css=".page-title")
	public WebElement searchErrorMsg;
	@FindBy(css=".search-field")
	public WebElement searchInnerField;
	@FindBy(css=".title.c-txt__title.noSpace")
	public WebElement headerLabel;
	@FindBy(css=".search-submit")
	public WebElement searchSubmitBtn;
	@FindBy(css=".main-nav__show-menu")
	public WebElement menuSearch;
	@FindBy(css=".internal-menu__bottom-item:nth-child(4)")
	public WebElement aboutLink;
	@FindBy(css=".menu-link.main-menu-link")
	public List<WebElement> upperMenu;
	@FindBy(css="#nav-menu-item-16222 .menu-link.sub-menu-link")
	public List<WebElement> dropDownMenu;
	@FindBy(css="[title=\"English\"] .wpml-ls-native")
	public WebElement englishLabel;
	@FindBy(css=".wpml-ls-native")
	public List<WebElement> languagesList;
	@FindBy(css="#nav-menu-item-21729>.menu-link.main-menu-link")
	public WebElement contactUsBtn;
	@FindBy(css="#nav-menu-item-17389")
	public WebElement companyMenu;
	
	public GeneralActionsPage(WebDriver driver) {
		super(driver);
	}
	
	//book a demo
	public void bookDemo() {
		click(bookDemoBtn);
	}
	
	//fill the form with all information
	@Step("Filling form with detailes: {firstname} {lastname} {email}")
	public void fillForm(String firstname, String lastname, String email, String phone, String company, String segment, String country, String interest) {
		fillText(firstNameField, firstname);
		fillText(lastNameField, lastname);
		fillText(emailField, email);
		fillText(phoneField, phone);
		fillText(companyField, company);
		selectByValue(marketSegmentField, segment);
//		selectByValue(countryField, country);
		fillText(interestField, interest);
		click(continueBtn);
	}
	
	//validation- check message content
	public String checkMsg() {
		return getText(contactMsg);
	}
	
	//click on continue button
	public void noFillForm() {
		click(continueBtn);
	}
	
	//validation- check missing info message 
		public String checkErrorMsg() {
			scrollTo(errorMsg);
			return getText(errorMsg);
		}
	
	
	//search text
	public void search(String text) throws InterruptedException {
		click(searchBtn);
		sleep(1000);
		fillText(searchField, text);
		searchField.submit();
	}
	
	//validation - check message for search not exist text
	public String searchInvalid() {
		return getText(searchErrorMsg);
	}
	
	//additional search after searching non exist text
	public void innerSearch(String text) {
		fillTextWithClear(searchInnerField, text);
		click(searchSubmitBtn);
	}
	
	//validation - check page for search exist text
	public String validSearch() {
		return getText(headerLabel);
	}
	
	//search "about" link by menu and click this link
	public void searchByMenu() throws InterruptedException {
		click(menuSearch);
		sleep(1000);
		scrollTo(aboutLink);
		getText(aboutLink);
		click(aboutLink);
	}
	
	//search one of the options from upper menu and hover on it
	public void chooseSupportMenu(String option) throws InterruptedException {
		for (WebElement element : upperMenu) {
			if (getText(element).equalsIgnoreCase(option)) {
				moveTo(element);
				sleep(1000);
				break;
			}
		}
	}
	
	//search one of the options under "Support" menu and click on it
	public void chooseElearningMenu(String option) {
		for (WebElement element : dropDownMenu) {
			if (getText(element).equalsIgnoreCase(option)) {
				click(element);
				break;
			}
		}
	}
	
	//hover on English and move to Italian 
	public void chooseLanguage(String language) {
		moveTo(englishLabel);
		for (WebElement element : languagesList) {
			if (getText(element).equalsIgnoreCase(language)) {
				click(element);
				break;
			}
		}
	}
	
	//click on contact us
	public void contactUs() {
		click(contactUsBtn);
	}
	
	//click on company menu option
	public void chooseCompany() {
		click(companyMenu);
	}
		
}
