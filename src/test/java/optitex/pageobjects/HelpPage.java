package optitex.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelpPage extends GeneralActionsPage {
	@FindBy(css="a.filter")
	public WebElement filterBtn;
	@FindBy(css=".filter-holder.left-pane.sidebar-opened.layout-visible li:nth-child(1) > label")
	public WebElement checkBoxPds;
	@FindBy(css=".filter-holder.left-pane.sidebar-opened.layout-visible > a")
	public WebElement filterIcon;
	@FindBy(css=".filter-holder.left-pane.sidebar-opened.layout-visible > p")
	public WebElement noFilterIcon;
	@FindBy(css="a.idx")
	public WebElement indexBtn;
	@FindBy(css=".IdxFilter")
	public WebElement indexField;
	@FindBy(css="li.treeitem.IndexKeyword")
	public List<WebElement> indexResults;
	@FindBy(css="a.glo")
	public WebElement glossaryBtn;
	@FindBy(css=".GloFilter")
	public WebElement glossaryField;
	@FindBy(css="span.GlossaryTermText")
	public WebElement glossaryResult;
	@FindBy(css=".fts.search-sidebar")
	public WebElement searchBtn;
	@FindBy(css=".search-input>.wSearchField")
	public WebElement searchField;
	@FindBy(css="#searchMsg")
	public WebElement searchResultMsg;
	@FindBy(css="iframe.topic")
	public WebElement frame;
	@FindBy(css="body > h1")
	public WebElement systemReqHeader;
	@FindBy(css=".title")
	public WebElement upperTitle;
		
	
	public HelpPage(WebDriver driver) {
		super(driver);
	}
	
	//filter PDS-2D option
	public void filterPds2D() throws InterruptedException {
		click(filterBtn);
		sleep(1000);
		click(checkBoxPds);
		sleep(1000);
	}

	//Validation - verify filter icon is marked
	public boolean checkFilterIcon() {
		try {
		if (filterIcon.isDisplayed()) {
			return true;
		}
		else
			return false;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//un-filter PDS-2D option
	public void unFilterPds2D() throws InterruptedException {
		click(checkBoxPds);
		sleep(500);
	}
	
	//filter via index "PDS"
	public void indexPDS(String filter) {
		click(indexBtn);
		fillText(indexField, filter);
	}
	
	//validation - number of results for filter by index "PDS"
	public long getIndexResult() {
		long numResults = 0;
		for (int i = 0; i < indexResults.size(); i++) {
			numResults = i + 1;
			}
		return numResults;
	}
	
	//filter via glossary "trim" and expand result
	public void glossaryOfTrim(String term) {
		click(glossaryBtn);
		fillText(glossaryField, term);
	}
	
	//validation - check results of trim
	public String checkGlossary() {
		return getText(glossaryResult);
	}
	
	//search "trim" 
	public void searchTrim(String text) throws InterruptedException {
		click(searchBtn);
		fillTextWithClear(searchField, text);
		searchField.sendKeys(Keys.RETURN); 
	}
	
	//validation - check results for "Trim"
	public boolean checkSreach(String text) throws InterruptedException {
		sleep(4000);
		return getText(searchResultMsg).contains(text);
	}
	
	//validation - check page is opened
	public String checkHeader() {
//		getFrame(frame);
//		return getText(systemReqHeader);
		return getText(upperTitle);
	}
}
