package optitex.pageobjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	WebDriver driver;
	Select select;
	Actions actions;
	JavascriptExecutor js;
	WebDriverWait wait;
	String defaultWindow;
	Set<String> childWindows;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 15); 
		defaultWindow = driver.getWindowHandle();
		childWindows = driver.getWindowHandles();
	}
	
	public void fillText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void fillTextWithClear(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void sleep(long milisec) throws InterruptedException {
		Thread.sleep(milisec);
	}
	
	public void selectByValue(WebElement element, String text) {
		select = new Select(element);
		select.selectByValue(text);
	}
	
	public void getAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	
	public void alertOK() {
		driver.switchTo().alert().accept();
	}
	
	public void alertCancel() {
		driver.switchTo().alert().dismiss();
	}
	
	public String alertGetText() {
		return driver.switchTo().alert().getText();
	}
	
	public void moveTo(WebElement element) {
		actions.moveToElement(element).build().perform();
	}
	
	public void getFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}
	
	public void scrollTo(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void SwitchSecondTab1() throws InterruptedException {
		  	for(String child : childWindows){
	  		if(!child.equalsIgnoreCase(defaultWindow)){
	  			driver.switchTo().window(child);
	  		} 
	  	}
	}
	
}
