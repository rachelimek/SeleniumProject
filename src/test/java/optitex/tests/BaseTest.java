package optitex.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


//This is base test to define the chrome browser, maximize window and get the site
public class BaseTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup(ITestContext testContext) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://optitex.com/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
