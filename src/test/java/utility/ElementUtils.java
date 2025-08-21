package utility;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FunctionalInterfaces.ElementAction;
import utility.FunctionalInterfaces.ElementCheck;
import utility.FunctionalInterfaces.Extractor;
import utility.FunctionalInterfaces.WaitCondition;

public class ElementUtils {

	private WebDriver driver;
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	//Generic Wait
	public void WaitUntil(WaitCondition condition, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(condition::check);
	}
	
	//actions
	public void doAction(By locator, ElementAction action) {
		WebElement element = driver.findElement(locator);
		action.perform(element);
	}
	
	//validate
	public boolean validate(By locator, ElementCheck check) {
		return check.validate(driver.findElement(locator));
	}
	
	//extracting
	public List<String> extractFromElements(By locator, Extractor<WebElement> extractor){
		return driver.findElements(locator)
				     .stream()
				     .map(extractor::extract)
				     .collect(Collectors.toList());
	}
}
