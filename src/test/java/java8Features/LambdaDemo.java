package java8Features;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LambdaDemo {

	@Test
	public void testLambda() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
		//without lambda
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.id("username")).isDisplayed();
			}
		});*/
		
		//with lambda
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(d -> d.findElement(By.id("username")).isDisplayed());
		
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		
		//without lambda
		/*List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link: allLinks) {
			if(link.isDisplayed()) {
				System.out.println(link.getText());
			}
		}*/
		
		//with lambda and Streams
		driver.findElements(By.tagName("a"))
		.stream()
		.filter(e -> e.isDisplayed())
		.forEach(e -> System.out.println(e.getText()));
		
		driver.quit();
	}
}
