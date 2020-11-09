package optitex.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage {
	@FindBy(css=".desc-wrap .title a")
	public List<WebElement> blogIcons;
	@FindBy(css=".next-link")
	public WebElement nextBtn;
	
	
	public BlogPage(WebDriver driver) {
		super(driver);
	}

	//count number of blogs in all pages
	public long blogCounterAllPages() throws InterruptedException {
		long counter = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < blogIcons.size(); j++) {
				counter++;
			}
			if (i < 5) {
				click(nextBtn);
				sleep(1000);
			}
		}
		return counter;
	}
}
