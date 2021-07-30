package app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import app.base.utils;

public class blazeHome extends utils{
	WebDriver driver; 	
	
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
	
	
	public void signUp(String user, String pass) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(userSign));
		writeInput(driver, userSign, user);
		writeInput(driver, passSign, pass);
		
		takeSnapShot(driver, "./ScreenShot_Folder/Test1_SignUp.png");
		
		Thread.sleep(2000);
		click(driver, btnSign);
		
		try {
			WebDriverWait waitAlert = new WebDriverWait(driver, 3);
			waitAlert.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert(); 
			String alertTxt = alert.getText();
			System.out.println(alertTxt);
			if(alertTxt.contains("exist")) {
				alert.dismiss();
				driver.quit();
			}else {
				alert.accept();
			}			
		}catch(NoAlertPresentException E) {
			System.out.println("No se encontró un alert");
		}
		System.out.println("Step1- SignUP");
	}
	
	public void logIn(String user, String pass) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(userLog));
		writeInput(driver, userLog, user);
		writeInput(driver, passLog, pass);
		takeSnapShot(driver, "./ScreenShot_Folder/Test1_Login.png");
		
		click(driver, btnLog);
		
		try {
			Alert alert;
			alert = driver.switchTo().alert(); 
			if(driver.equals(alert)) {
				String alertTxt = alert.getText();
				System.out.println(alertTxt);
				alert.accept();			
				driver.quit();
			}
		}catch(NoAlertPresentException e) {
			System.out.println("Logged in Successfully");
		}			
		System.out.println("Step1- LogIn");
	}
}
