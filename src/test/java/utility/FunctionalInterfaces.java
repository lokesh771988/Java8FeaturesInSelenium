package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface FunctionalInterfaces {

	@FunctionalInterface
	public interface WaitCondition{
		boolean check(WebDriver driver);
	}
	
	@FunctionalInterface
	public interface ElementCheck{
		boolean validate(WebElement element);
	}
	
	@FunctionalInterface
	public interface ElementAction{
		void perform(WebElement element);
	}
	
	@FunctionalInterface
	public interface Extractor<T>{
		String extract(T element);
	}
}
