package app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.base.utils;


public class blazeNav extends utils {
	WebDriver driver;
	
	public blazeNav(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'Home')]")
	private WebElement home;
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'Contact')]")
	private WebElement contact;
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'About us")
	private WebElement aboutUs;
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'Cart')]")
	private WebElement cart;
	
	@FindBy(xpath = "//ul/li/a[contains(text(),'Log in')]")
	private WebElement login;
	
	@FindBy(id = "signin2")
	private WebElement signUp;
	
	
	public void navegate(String place) {
		
		if(place == "home") {
			home.click();
		}else if(place == "contacto") {
			contact.click();
		}else if(place == "carrito") {
			cart.click();
		}else if(place == "log") {
			login.click();
		}else if(place == "sign") {
			signUp.click();
		}
	}
}
