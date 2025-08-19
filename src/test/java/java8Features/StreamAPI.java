package java8Features;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamAPI {

	@Test
	public void stream() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		List<String> visibleLinks = driver.findElements(By.tagName("a"))
								    .stream()
								    .filter(WebElement::isDisplayed)
								    .map(WebElement::getText)
								    .filter(text -> !text.isEmpty())
								    .collect(Collectors.toList());
		visibleLinks.forEach(System.out::println);
		
		WebElement googleLink = driver.findElements(By.tagName("a"))
			                    .stream()
			                    .filter(e -> e.getText().contains("Google"))
			                    .findFirst()
			                    .orElseThrow(()->new NoSuchElementException("Link nt found"));
		googleLink.click();
		
		List<String> image = driver.findElements(By.tagName("img"))
                             .stream()
                             .map(e -> e.getAttribute("src"))
                             .collect(Collectors.toList());
		image.forEach(System.out::println);
		
		
		Long count = driver.findElements(By.tagName("a"))
					 .stream()
					 .filter(e->e.getText().contains("Google"))
					 .count();
		System.out.println(count);
		driver.quit();
	}
}
