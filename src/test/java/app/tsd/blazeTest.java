package app.tsd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import app.base.Data;
import app.base.baseTest;
import app.pages.blazeHome;
import app.pages.blazeNav;
import app.pages.blazeProduct;
import app.pages.blazeCart;

public class blazeTest extends baseTest {

//	public Report report;

	public blazeHome home;
	public blazeProduct product;
	public blazeNav nav;
	public blazeCart cart;
	
	public Object obj;
	public Data data;
	public JSONObject json;

	@BeforeClass
	public void setupClases() throws IOException, ParseException {
		home = new blazeHome(driver);
		product = new blazeProduct(driver);
		nav = new blazeNav(driver);
		cart = new blazeCart(driver);
		
		//Read JSON File
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\ana.martinezm\\Desktop\\Room3_Workshop 7_26_21\\data.json");
		obj = jsonParser.parse(reader);
		
		ObjectMapper objectMapper = new ObjectMapper();
		data = objectMapper.readValue(obj.toString(), Data.class);
	}

//	@Test(priority=1)
//	ExtentTest testReport = extent.createTest("Log In", "Log in into account");
//	public void signUp() throws Exception{
//		//Step 1 Sign UP
//		nav.navegate("sign");
//		home.signUp("mauriciotest", "12345");
//	}

	@Test(priority = 1)
	public void logIn() throws Exception {
		// Step 2
		ExtentTest testReport = extent.createTest("Log In", "Log in into account");
		testReport.log(Status.INFO, "Test LOG IN initiated.");

		nav.navegate("log");
		testReport.pass("Click on NavBar option Log In");

		home.logIn(data.User.Username, data.User.Password);
		testReport.pass("Logged In");
		testReport.log(Status.INFO, "Test LOG IN finalized");
	}

	@Test(priority = 2)
	public void addCart() throws Exception {
		ExtentTest testReport = extent.createTest("Add Cart", "Add Products to Cart");
		try {
			// Step 1 Select Product
			testReport.log(Status.INFO, "Test Add Cart initiated.");
			
			product.details(data.Order.Product.Name);
			testReport.pass("Click on product");

			// Step2 add to car
			product.add();
			testReport.pass("Product added to Cart");

			// Step 3 back to home
			nav.navegate("home");
			testReport.pass("Navigate to home");
			testReport.log(Status.INFO, "Test Add Cart finalized");
		} catch (Exception e) {
			testReport.log(Status.ERROR, "Error in Method!");
		}
	}

	@Test(priority = 3)
	public void purchaseOrder() throws Exception {
		// Step 1 Navigate to Cart
		ExtentTest testReport = extent.createTest("Purchase Order", "Purchase selected products");
		testReport.log(Status.INFO, "Test Purchase Order initiated.");

		nav.navegate("carrito");
		testReport.pass("Click on NavBar option Cart");

		// Step 2 Place Order
		cart.Order();
		testReport.pass("Click on Place Order.");

		cart.Fill();
		testReport.log(Status.INFO, "Form Filled");

		cart.Purchase();
		testReport.pass("Order Purchased");

		cart.Confirm();
		testReport.pass("Purchase Confirmed");
		testReport.log(Status.INFO, "Test Purchase Order finalized");
	}

}
