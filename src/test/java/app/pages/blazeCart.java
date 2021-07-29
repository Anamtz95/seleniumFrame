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
import app.base.*;

public class blazeCart {
	WebDriver driver; 
	public blazeCart(WebDriver drive) {
		this.driver = drive;
		
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
	private WebElement btnOrder;	
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[2]/form/div/input[@id='name']")
	private WebElement txtName;
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[2]/form/div/input[@id='country']")
	private WebElement txtCountry;
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[2]/form/div/input[@id='city']")
	private WebElement txtCity;
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[2]/form/div/input[@id='card']")
	private WebElement txtCCard;	
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[2]/form/div/input[@id='month']")
	private WebElement txtMonth;
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[2]/form/div/input[@id='year']")
	private WebElement txtYear;
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[2]")
	private WebElement btnPurchase;
	
	@FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[1]")
	private WebElement btnClose;
	
	@FindBy(xpath = "//*[@class='sweet-alert  showSweetAlert visible']/div[7]/button")
	private WebElement btnConfirm;
		
		
		
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
		
	//Methods
	public void Nav(String xpath) {
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("test-succesfully");
	}	
	
	public void Order() {
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-wrapper']/div/div[2]/button")));
		btnOrder.click();
		System.out.println("test-succesfully");
	}
	
	public void Purchase() {
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]")));
		btnPurchase.click();
		System.out.println("test-succesfully");
	}
	
	public void Confirm() {
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sweet-alert  showSweetAlert visible']/div[7]/button")));
		btnConfirm.click();
		System.out.println("test-succesfully");
	}
	
	public void Close() {
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='orderModal']/div/div/div[3]/button[1]")));
		btnClose.click();
		System.out.println("test-succesfully");
	}
	
	public void Fill() {
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='orderModal']/div/div/div[2]/form/div/input")));
		utils.writeInput(driver, txtName, "Mike");		
		utils.writeInput(driver, txtCountry, "Mexico");	
		utils.writeInput(driver, txtCity, "San Luis Potosi");	
		utils.writeInput(driver, txtCCard, "1234567890");	
		utils.writeInput(driver, txtMonth, "07");	
		utils.writeInput(driver, txtYear, "2025");	
	}

}
