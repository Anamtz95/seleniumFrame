package app.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class utils {
	
	public static void writeInput(WebDriver driver, WebElement element, String value){
		try {
			element.sendKeys(value);	
		}catch(Exception e){
			System.out.println("No hay de esos");
			driver.quit();
		}

	}
	
	public static void click(WebDriver driver, WebElement element) {
		try {
			element.click();
		}catch(Exception e) {
			System.out.println("No hay esa opcion");
			driver.quit();
		}
	}
	
	public static void SelectOptions(WebDriver driver, WebElement element, String option) {
		Select select = new Select(element);
		select.selectByValue(option);	
	}
	
//	public static void uploadElement(WebDriver driver, String xPath, String value) {
//
//		WebElement element;
//
//		try {
//		element= driver.findElement(By.xpath(xPath));
//		element.sendKeys(value);
//		}catch(Exception e) {
//		System.out.println("Element " + xPath + " no encontrado.");
//		driver.quit();
//		}
//	}
}
