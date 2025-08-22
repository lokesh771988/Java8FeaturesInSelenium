package java8Features;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.WaitUtils;

public class DefaultAndStatic implements WaitUtils {

	@Test
	public void defaultAndStatic() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
		DefaultAndStatic obj = new DefaultAndStatic();
		obj.waitForVisible(driver, By.id("username"), 10);
		obj.typeText(driver, By.id("username"), "tomsmith");
		
		//password
		obj.waitForVisible(driver, By.id("password"), 10);
		obj.typeText(driver, By.id("password"), "SuperSecretPassword!");
		
		//click
		obj.clickElement(driver, By.xpath("//button[@type='submit']"));
		
		WaitUtils.takeScreenshot(driver, "login");
		Thread.sleep(1000);
		driver.quit();
	}
}
