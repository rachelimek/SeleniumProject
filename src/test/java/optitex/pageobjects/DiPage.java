package optitex.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiPage extends GeneralActionsPage {
	@FindBy(css="#animate-video-play")
	private WebElement videoPlayBtn;
	@FindBy(css="#player")
	public WebElement videoFrame;
	@FindBy(css="a.ytp-title-link.yt-uix-sessionlink")
	public WebElement videoHeader;
			
	public DiPage(WebDriver driver) {
		super(driver);
	}
	
	public void watchVideo() throws InterruptedException {
		sleep(1000);
		js.executeScript("window.scrollBy(0,1500)");
		sleep(2000);
 		click(videoPlayBtn);
 	}
	
	//validation - verify video is executed
	public String checkVedioOn() {
		getFrame(videoFrame);
		return getText(videoHeader);
	}

}
