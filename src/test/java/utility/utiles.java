package utility;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utiles {
	
	public static String getSrc(WebElement e) {
		return e.getAttribute("src");
	}
	
	public static Boolean isElementVisible(WebDriver driver) {
		return driver.findElement(By.id("APjFqb")).isDisplayed();
	}

	public static Boolean isElementVisible(WebDriver driver, By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch (NoSuchElementException e) {
			return false;
		}
		
	}
}
