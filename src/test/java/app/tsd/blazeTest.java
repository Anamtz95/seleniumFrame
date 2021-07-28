package app.tsd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import app.base.baseTest;
import app.pages.blazeHome;
import app.pages.blazeProduct;

public class blazeTest extends baseTest{
	
	public blazeHome home;
	public blazeProduct product;
	
	@BeforeClass
	public void setupClases() {
		home = new blazeHome(driver);
		product = new blazeProduct(driver);
	}
	
	@Test
	public void test() throws InterruptedException{
		product.details("//h4//a[@href='prod.html?idp_=1']");
		product.add();
	}

}
