package MissionDrone.FlightPlan;

import javax.management.openmbean.OpenDataException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.TestCase;
import objectModel.LandingPageObjects;
import objectModel.OpenStreetObjects;

/**
 * Unit test for simple App.
 */
public class DroneTests extends TestCase {

	private static WebDriver driver = null;

	@BeforeMethod
	public static void initialize() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		driver.manage().deleteAllCookies();
	}

	@Test
	public void creatingAFlightPlan() throws Exception {
		driver.get("https://stupendous-birth.surge.sh/");
		LandingPageObjects.createNewFlightPlanButton(driver).click();
		Thread.sleep(1000);
		
		OpenStreetObjects.svgImage(driver).click();
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		OpenStreetObjects.column(driver);
		actions.clickAndHold(OpenStreetObjects.column(driver)).moveByOffset(150, 100).click().build().perform();
		
		actions.click(OpenStreetObjects.mapQuadrant(driver)).perform();

	}

}
