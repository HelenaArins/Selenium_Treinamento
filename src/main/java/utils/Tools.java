package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
	public static WebElement waitBy(WebElement element, WebDriver driver) {		
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(element));
		return element;
	}
}
