package app.base;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;


public class utils {
	
	public static void writeInput(WebDriver driver, WebElement element, String value){
		try {
			element.sendKeys(value);	
		}catch(Exception e){
			System.out.println("No existe el input");
			driver.quit();
		}

	}
	
	public static void click(WebDriver driver, WebElement element) {
		try {
			element.click();
		}catch(Exception e) {
			System.out.println("No puede realizar esa opcion");
			driver.quit();
		}
	}
	
	public static void SelectOptions(WebDriver driver, WebElement element, String option) {
		Select select = new Select(element);
		select.selectByValue(option);	
	}
	
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File(fileWithPath);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        
        //Thread.sleep(2000);        ??
    }
}
