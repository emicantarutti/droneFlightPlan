package missionDrone.flightPlan.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.TestCase;
import missionDrone.flightPlan.objectModel.LandingPageObjects;
import missionDrone.flightPlan.objectModel.MissionObjects;
import missionDrone.flightPlan.objectModel.OpenStreetObjects;
import missionDrone.flightPlan.waits.WaitForPageToLoad;

/**
 * Created by Emiliano Cantarutti
 */
public class CreateANamelessFlightPlan extends TestCase {

	private static WebDriver driver = null;
	private static String url = "https://stupendous-birth.surge.sh/";
	WaitForPageToLoad waiting = new WaitForPageToLoad();
	WebDriverWait wait;
	Actions actions;
	String value;
	
	@BeforeClass
	public void setUp(){
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
		}
		wait = new WebDriverWait(driver, 10);
		actions = new Actions(driver);
	}
	
	
	@BeforeMethod
	public static void initialize() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

	}
	
	@AfterMethod
	public static void closingUp(){
		driver.close();
	}


	@Test
	public void creatingANamelessPlan() throws Exception {
		LandingPageObjects.createNewFlightPlanButton(driver).click();
		waiting.waitForLoad(driver);
		
		//Here the route gets created
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.column(driver)));
		actions.clickAndHold(OpenStreetObjects.column(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mainDiv(driver)));
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mapQuadrant(driver)));
		actions.clickAndHold(OpenStreetObjects.mapQuadrant(driver)).moveByOffset(50, 50).click().build().perform();
		
		
		//Opening the last created route - it should be autosaved
		MissionObjects.selectingACreatedFlight(driver, 1).click();
		
		//Verification that the first coordinate matches the starting point of the route
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		Assert.assertTrue((value = MissionObjects.coordinates(driver).getAttribute("innerHTML")).startsWith("#1: N46."));
		

	}
}
