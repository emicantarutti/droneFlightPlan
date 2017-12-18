package MissionDrone.FlightPlan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.TestCase;
import objectModel.LandingPageObjects;
import objectModel.MissionObjects;
import objectModel.OpenStreetObjects;
import waits.WaitForPageToLoad;

/**
 * Created by Emiliano Cantarutti
 */
public class CreateANewFlightPlan extends TestCase {

	private static WebDriver driver = null;
	private static String url = "https://stupendous-birth.surge.sh/";
	WaitForPageToLoad waiting = new WaitForPageToLoad();

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
		driver.get(url);
		
	}
	
	/*@AfterMethod
	public static void closingUp(){
		driver.close();
	}*/

	@Test
	public void creatingAFlightPlan() throws Exception {
		waiting.waitForLoad(driver);
		LandingPageObjects.createNewFlightPlanButton(driver).click();
		waiting.waitForLoad(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mainDiv(driver)));
		
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.column(driver)));
		actions.clickAndHold(OpenStreetObjects.column(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mainDiv(driver)));
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mapQuadrant(driver)));
		actions.clickAndHold(OpenStreetObjects.mapQuadrant(driver)).moveByOffset(50, 50).click().build().perform();
		
		
		
		MissionObjects.flightTitle(driver).click();
		MissionObjects.flightTitle(driver).clear();
		MissionObjects.flightTitle(driver).sendKeys("Flight#1");
		MissionObjects.flightTitle(driver).sendKeys(Keys.ENTER);
		
		MissionObjects.selectingACreatedFlight(driver, 1).click();
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		String value = MissionObjects.coordinates(driver).getAttribute("innerHTML");
		Assert.assertTrue(value.startsWith("#1: N46."));
		

	}
	
	@Test
	public void aNewFlightPlan() throws Exception{
		creatingAFlightPlan();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		waiting.waitForLoad(driver);
				
		MissionObjects.addNewFlight(driver).click();
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mapQuadrant(driver)));
		actions.clickAndHold(OpenStreetObjects.mapQuadrant(driver)).moveByOffset(50, 50).click().build().perform();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(MissionObjects.flightTitle(driver)));
		
		MissionObjects.selectingACreatedFlight(driver, 1).click();
		
	}
	
	@Test
	public void newFlightThruFirstOneButton(){
		LandingPageObjects.createFirstOneButton(driver).click();
		
		
		waiting.waitForLoad(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(10, 250).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.column(driver)));
		actions.clickAndHold(OpenStreetObjects.column(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mainDiv(driver)));
		actions.clickAndHold(OpenStreetObjects.mainDiv(driver)).moveByOffset(150, 100).click().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(OpenStreetObjects.mapQuadrant(driver)));
		actions.clickAndHold(OpenStreetObjects.mapQuadrant(driver)).moveByOffset(50, 50).click().build().perform();
	
		
	}

}
