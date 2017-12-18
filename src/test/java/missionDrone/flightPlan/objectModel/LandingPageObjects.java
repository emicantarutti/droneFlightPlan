package missionDrone.flightPlan.objectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {
	private static WebElement element = null;

	public static WebElement createNewFlightPlanButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class = 'md-raised md-primary md-button md-ink-ripple']"));
		return element;
	}
	
	public static WebElement createFirstOneButton(WebDriver driver){
		element = driver.findElement(By.xpath("//a[@ng-click= 'store.createFlightPlan()']"));
		return element;
	}
	
}
