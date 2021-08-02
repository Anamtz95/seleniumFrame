package app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import app.base.utils;



public class blazeProduct extends utils{
	WebDriver driver; 
	
	public blazeProduct(WebDriver drive) {
		this.driver = drive;
		
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath = "//*[text()='Add to cart']")
	private WebElement addBtn;
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	//Methods
	public void details(String producto) throws InterruptedException {
		////*[@class='hrefch' and contains(text(),'Samsung galaxy s6')]
		String xpath = "//*[@class='hrefch' and contains(text(),'";
		xpath = xpath + producto;
		xpath = xpath + "')]";
		System.out.println(xpath);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("test-succesfully");
	}
	
	public void add() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add to cart']")));
		addBtn.click();
		takeSnapShot(driver, "./ScreenShot_Folder/Test1_AddCart.png");
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("test-succesfully");
	}
	
	
}
