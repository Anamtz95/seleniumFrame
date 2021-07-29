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

public class blazeHome {

	WebDriver driver; 
	public utils method;
	
	
	public blazeHome(WebDriver drive) {
		this.driver = drive;
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Elements signUp
	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement userSign;
	
	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement passSign;
	
	@FindBy(xpath = "//button[@onclick='register()']")
	private WebElement btnSign;
	
	//Elements logIn
	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement userLog;
	
	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement passLog;
	
	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement btnLog;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	
	public void signUp(String user, String pass) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sign-username']")));
		method.writeInput(driver, userSign, user);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sign-password']")));
		method.writeInput(driver, passSign, pass);
		
		method.click(driver, btnSign);
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println("Step1- SignUP");
	}
	
	public void logIn(String user, String pass) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));
		method.writeInput(driver, userLog, user);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginpassword']")));
		method.writeInput(driver, passLog, pass);
		
		method.click(driver, btnLog);
		
		System.out.println("Step1- SignUP");
	}
}
