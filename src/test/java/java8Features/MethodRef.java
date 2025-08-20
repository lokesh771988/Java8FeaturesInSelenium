package java8Features;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.utiles;

public class MethodRef {

	@Test
	public void methodRef() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(utiles::isElementVisible);
		By textbox = By.id("APjFqb");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(d ->utiles.isElementVisible(driver,textbox));
		
		driver.findElements(By.tagName("a"))
		      .forEach(link -> System.out.println(link.getText()));
		
		//method reference
		driver.findElements(By.tagName("a"))
			  .stream()
			  .map(WebElement::getText) //instance method reference
			  .forEach(System.out::println); //static method reference
		
		List<String> image = driver.findElements(By.tagName("img"))
                .stream()
                .map(utiles::getSrc) //static method reference
                .collect(Collectors.toList());
		image.forEach(System.out::println);
		
		driver.quit();
	}
}
