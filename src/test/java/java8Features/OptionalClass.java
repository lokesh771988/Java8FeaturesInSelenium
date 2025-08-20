package java8Features;

import java.util.Optional;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OptionalClass {

	@Test
	public void optionalMethod() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		//driver.findElement(By.name("signup1")).click();
		//safe
		Optional<WebElement> login = driver.findElements(By.name("signup1"))
										   .stream()
										   .findFirst();
		
		login.ifPresent(WebElement::click);
		
		String msg = driver.findElements(By.xpath("//a[text()='WebTable']"))
						   .stream()
						   .findFirst()
						   .map(WebElement::getText)
						   .orElse("No value found");
		System.out.println(msg);
				
		//conditional assertions
		Optional<WebElement> login1 = driver.findElements(By.name("signup"))
				   .stream()
				   .findFirst();
		
		boolean error = login1.map(WebElement::isDisplayed).orElse(false);
		System.out.println(error);
		
		//screenshot
		Optional<WebElement> login2 = driver.findElements(By.name("signup1"))
				   .stream()
				   .findFirst();
		
		login2.ifPresent(e -> {
			System.out.println("Screenshot taken");
		});
		driver.quit();
	}
}
