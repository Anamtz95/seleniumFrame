package app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class blazeNav {
	WebDriver driver;
	
	public blazeNav(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='index.html'])[2]")
	private WebElement home;
	
	@FindBy(xpath = "")
	private WebElement contact;
	
	@FindBy(xpath = "")
	private WebElement aboutUs;
	
	@FindBy(xpath = "")
	private WebElement cart;
	
	@FindBy(xpath = "")
	private WebElement login;
	
	@FindBy(xpath = "")
	private WebElement signUp;
	
	
}
