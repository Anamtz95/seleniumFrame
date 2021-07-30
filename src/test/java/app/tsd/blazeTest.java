package app.tsd;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import app.base.baseTest;
import app.pages.blazeHome;
import app.pages.blazeNav;
import app.pages.blazeProduct;
import app.pages.blazeCart;

public class blazeTest extends baseTest{
	
	public blazeHome home;
	public blazeProduct product;
	public blazeNav nav;
	public blazeCart cart;
	
	@BeforeClass
	public void setupClases() {
		home = new blazeHome(driver);
		product = new blazeProduct(driver);
		nav = new blazeNav(driver);
		cart = new blazeCart(driver);
	}
	
//	@Test(priority = 1)
//	public void automatePurchase() throws Exception{
//		nav.navegate("log");
//		home.logIn("mauriciotest123", "12345");
//		product.details("//h4//a[@href='prod.html?idp_=1']");
//	
//	}
//	
//	@Test(priority=1)
//	public void signUp() throws Exception{
//		//Step 1 Sign UP
//		nav.navegate("sign");
//		home.signUp("mauriciotest", "12345");
//	}
	
	@Test(priority=1)
	public void logIn() throws Exception {
		//Step 2
		nav.navegate("log");
		home.logIn("mauriciotest", "12345");
	}
	
	@Test(priority=2)
	public void addCart() throws Exception {
		//Step 1 Select Product
		product.details("//h4//a[@href='prod.html?idp_=1']");
		//Step2 add to car
		product.add();
		//Step 3 back to home
		nav.navegate("home");
	}
	
	@Test(priority=3)
	public void purchaseOrder() throws Exception {
		nav.navegate("carrito");
		cart.Order();
		cart.Fill();
		cart.Purchase();
		cart.Confirm();
	}

}
