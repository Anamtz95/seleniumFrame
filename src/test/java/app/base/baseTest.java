package app.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class baseTest {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setupDriver() throws InterruptedException {
		//This is executed before the whole testing begins
				System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://www.google.com");
				driver.manage().window().maximize();
				Thread.sleep(2000);
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
