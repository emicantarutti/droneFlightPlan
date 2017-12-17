package objectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenStreetObjects {
	private static WebElement element = null;
	
	public static WebElement mainDiv(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class = 'leaflet-overlay-pane']"));
		return element;
	}
	
	public static WebElement svgImage(WebDriver driver){
		element = driver.findElement(By.cssSelector("svg[class='leaflet-zoom-animated']"));
		return element;
	}
	
	public static WebElement mapQuadrant(WebDriver driver){
		element = mainDiv(driver).findElement(By.xpath("//img[@src= '//b.tile.openstreetmap.org/17/67927/46356.png']"));
		return element;
	}
	
	public static WebElement column(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class= 'layout-column flex']"));
		return element;
	}
	
}
