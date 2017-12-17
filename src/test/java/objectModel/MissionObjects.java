package objectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MissionObjects {
	private static WebElement element = null;
	
	public static WebElement flightTitle(WebDriver driver) {
		element = driver.findElement(By.id("input_0"));
		return element;
	}
	
	public static WebElement savedFlights(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class= 'md-no-style md-button md-ink-ripple']"));
		return element;
	}
	
	public static WebElement savedFlightByName(WebDriver driver, String linkText) {
		element = savedFlights(driver).findElement(By.linkText(linkText));
		return element;
	}
	
	
}
