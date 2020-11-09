package optitex.pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends GeneralActionsPage {
	@FindBy(css=".intro__button.button.button--black")
	public WebElement exploreProductsBtn;
	@FindBy(css=".footer__logo")
	public WebElement footerLogo;
	@FindBy(css=".gotop.gotop--visible")
	public WebElement goTopArrow;
	@FindBy(css=".intro__title.title_main")
	public WebElement introTitleLabel;
	@FindBy(css="#pointCollar")
	public WebElement collarPoint;
	@FindBy(css="#title_3")
	public WebElement fabricHoverLabel;
	@FindBy(css="#pointTriangle3")
	public WebElement bottomPoint;
	@FindBy(css="#title_5")
	public WebElement advanceHoverLabel; 
	@FindBy(css="div:nth-child(5) > ul > li:nth-child(4) > a")
	public WebElement blogLabel;
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	//click on explore our Products 
	public void exploreProducts() {
		click(exploreProductsBtn);
	}
	
	//define main window as default window, define window on second tab as child window and move to this tab 
	public void SwitchSecondTab() throws InterruptedException {
		String defaultWindow = driver.getWindowHandle();
		sleep(3000);
	  	Set<String> childWindows = driver.getWindowHandles();
	  	for(String child : childWindows){
	  		if(!child.equalsIgnoreCase(defaultWindow)){
	  			driver.switchTo().window(child);
	  		} 
	  	}
	}
	
	//scroll down to window's bottom and click on go up arrow  
	public void ScrollDownUp() throws InterruptedException {
		scrollTo(footerLogo);
		sleep(1000);
		click(goTopArrow);
	}
	
	//validation - check introduction title
	public String getIntroTitle() {
		return getText(introTitleLabel);
	}
	
	//hover on coat's left top point
	public void hoverCoatTop() {
		moveTo(collarPoint);
	}
	
	//validation - check "rich fabric library" label is displayed
	public String getHoverCoatTop() {
		return getText(fabricHoverLabel);
	}
	
	//hover on coat's left bottom point
	public void hoverCoatBottom() {
		moveTo(bottomPoint);
	}
	
	//validation - check "Advanced 3D prototyping" label is displayed
	public String getHoverCoatbottom() {
		return getText(advanceHoverLabel);
	}
	
	//validation - check page is displayed on Italian 
	public String checkLanguage() {
		return getText(introTitleLabel);
	}
	
	//scroll to "Blog" and click on it
	public void openBlog() throws InterruptedException {
		scrollTo(footerLogo);
		sleep(1000);
		click(blogLabel);
	}
}
