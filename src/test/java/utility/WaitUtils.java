package utility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface WaitUtils {

	default void waitForVisible(WebDriver driver, By locator, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds))
		    .until(d->d.findElement(locator).isDisplayed());
	}
	
	//text file
	default void typeText(WebDriver driver, By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	default void clickElement(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}
	
	static void takeScreenshot(WebDriver driver, String fileName) {
		try {
			String timestamp = LocalDateTime.now()
					.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(screenshot.toPath(), Paths.get("screenshots/"+fileName+"_"+timestamp+".png"));
			System.out.println("screenshot taken");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
