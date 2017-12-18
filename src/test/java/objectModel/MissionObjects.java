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
		element = driver.findElement(By.cssSelector(".md-no-style.md-button.md-ink-ripple[0])"));
		return element;
	}

	public static WebElement savedFlightByName(WebDriver driver, String linkText) {
		element = savedFlights(driver).findElement(By.xpath("//h3[text() ='" + linkText + "']"));
		return element;
	}

	public static WebElement addNewFlight(WebDriver driver) {
		element = driver.findElement(By.cssSelector("button[ng-click= 'store.createFlightPlan()']"));
		return element;
	}

	public static WebElement selectingACreatedFlight(WebDriver driver, int i) {
		element = driver.findElement(By.xpath("//md-list-item[" + i + "]"));
		return element;
	}

	public static WebElement coordinates(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div[class= 'leaflet-popup-content ng-scope']"));
		return element;
	}

}
