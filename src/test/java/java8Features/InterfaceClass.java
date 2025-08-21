package java8Features;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ElementUtils;
import utility.FunctionalInterfaces.ElementAction;
import utility.FunctionalInterfaces.ElementCheck;
import utility.FunctionalInterfaces.Extractor;

public class InterfaceClass {

	@Test
	public void interfaceMethod() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
		ElementUtils utils = new ElementUtils(driver);
		
		//wait
		utils.WaitUntil(d ->d.findElement(By.id("username")).isDisplayed(), 10);
		utils.WaitUntil(d ->d.findElement(By.id("password")).isDisplayed(), 10);
		
		//action
		utils.doAction(By.id("username"), e->e.sendKeys("tomsmith"));
		utils.doAction(By.id("password"), e->e.sendKeys("SuperSecretPassword!"));
		
		//visible
		ElementCheck isDisplayed = WebElement::isDisplayed;
		boolean logoutVisible = utils.validate(By.xpath("//button[@type='submit']"), isDisplayed);
		System.out.println("logout button is visible :::"+logoutVisible);
		
		//method reference
		ElementAction click = WebElement::click;
		utils.doAction(By.xpath("//button[@type='submit']"), click);
		
		Extractor<WebElement> getText = WebElement::getText;
		List<String> links = utils.extractFromElements(By.tagName("a"), getText);
		links.forEach(System.out::println);
		
		driver.quit();
	}
}
