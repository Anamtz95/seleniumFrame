package app.tsd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import app.base.baseTest;
import app.pages.googleHome;

public class googleTest extends baseTest{
	
	public googleHome home; 
	
	@BeforeClass
	public void setupClases() {
		home = new googleHome(driver);
	}
	
	@Test
	public void test() throws InterruptedException{
		home.buscar("walmart");
	}

}
