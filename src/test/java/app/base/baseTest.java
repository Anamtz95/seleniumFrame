package app.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class baseTest {
	
	public WebDriver driver;
	
	public ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	public ExtentReports extent = new ExtentReports();
	
	@BeforeTest
	public void setupDriver() throws InterruptedException {
		//This is executed before the whole testing begins
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ana.martinezm\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\mauricio.neira\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.demoblaze.com");
				driver.manage().window().maximize();
				extent.attachReporter(htmlReporter);
	}
	
	@AfterTest
	public void closeDriver() {
		extent.flush();
		driver.quit();
	}

}
