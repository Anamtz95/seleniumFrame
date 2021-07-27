package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleHome {

	WebDriver driver; 
	
	public googleHome(WebDriver drive) {
		this.driver = drive;
		
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath = "//input[@title= 'Buscar']")
	private WebElement boxtest;
	
	@FindBy(xpath = "(//input[@name='btnK'])[2]")
	private WebElement buscarbtn;
	
	public void buscar(String cadena){
		
		boxtest.sendKeys(cadena);
		buscarbtn.click();
		//Thread.sleep(2000);
		//WebElement link = driver.findElement(By.xpath("//div[contains(text(),'Compra en Walmart - Envío Sin Costo y Hasta 20 MSI')]"));
		//link.click();
	}
}
