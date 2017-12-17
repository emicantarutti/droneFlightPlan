package MissionDrone.FlightPlan;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.MissingCommandException;

import junit.framework.TestCase;
import objectModel.LandingPageObjects;
import objectModel.MissionObjects;
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://stupendous-birth.surge.sh/");
		LandingPageObjects.createNewFlightPlanButton(driver).click();
		Thread.sleep(1000);
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.column(driver)));
		actions.clickAndHold(OpenStreetObjects.column(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mainDiv(driver)));
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mapQuadrant(driver)));
		actions.clickAndHold(OpenStreetObjects.mapQuadrant(driver)).moveByOffset(50, 50).click().build().perform();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(MissionObjects.flightTitle(driver)));
		
		MissionObjects.flightTitle(driver).click();
		MissionObjects.flightTitle(driver).sendKeys("Flight#1");
		MissionObjects.flightTitle(driver).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(MissionObjects.savedFlightByName(driver, "Flight#1")));
		Thread.sleep(1000);
		
		MissionObjects.savedFlights(driver).click();
		
		MissionObjects.savedFlightByName(driver, "Flight#1");
		

	}

}
