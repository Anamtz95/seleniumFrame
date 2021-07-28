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
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ana.martinezm\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mauricio.neira\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.demoblaze.com");
				driver.manage().window().maximize();
//				Thread.sleep(2000);
	}
	
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
