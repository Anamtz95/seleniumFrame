package app.tsd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import app.base.baseTest;
import app.pages.blazeHome;
import app.pages.blazeNav;
import app.pages.blazeProduct;

public class blazeTest extends baseTest{
	
	public blazeHome home;
	public blazeProduct product;
	public blazeNav nav;
	
	
	@BeforeClass
	public void setupClases() {
		home = new blazeHome(driver);
		product = new blazeProduct(driver);
		nav = new blazeNav(driver);
	}
	
	@Test
	/*public void test() throws InterruptedException {
		//Step 1 Sign UP
				nav.navegate("sign");
				home.signUp("testA", "12345");
		//Step 2 LogIn
				nav.navegate("log");
				home.logIn("testA", "12345");
		//Step 3 select product
				product.details("//h4//a[@href='prod.html?idp_=1']");
		//Step 4 add product
				product.add();
	}*/
	public void signUp() throws InterruptedException{
		//Step 1 Sign UP
		nav.navegate("sign");
		home.signUp("test", "12345");
	}
	
	@Test
	public void logIn() {
		nav.navegate("log");
		home.logIn("test", "12345");
	}
	
	@Test
	public void addCart() {
		//Step 1 Select Product
		product.details("//h4//a[@href='prod.html?idp_=1']");
		
		//Step2 add to car
		product.add();
	}

}
