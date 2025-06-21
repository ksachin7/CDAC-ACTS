import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGPractice {
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://artoftesting.com/samplesiteforselenium");
	}

	@Test
	public void verifyPageTitleTest() {
		String title= driver.getTitle();
		System.out.println("Page Title: "+title);
//		if(title.equals("Sample Webpage for Selenium Automation Practice | ArtOfTesting"));
		Assert.assertEquals(title, "Sample Webpage for Selenium Automation Practice | ArtOfTesting");
		
//        assertTrue(driver.getTitle().toLowerCase().contains("selenium webdriver"));
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null )driver.quit();
	}
}
