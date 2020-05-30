package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FlightFinder;
import pages.IndexPage;

/* Verify the search for flights whit the same destination and origin*/
public class SB_44_SameDestinyAndOriginTest {
	
	private String baseUrl = "http://newtours.demoaut.com";
	
	private WebDriver driver;
	
	private IndexPage welcome;
	
	private FlightFinder findFlight;
	
	private String actualTitle;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver","./Drivers/Windows83/chromedriver.exe");					
		
		driver = new ChromeDriver();
		
		driver.get(baseUrl);
	
	}
	
	@Test
	public void verifyTheSearchWhitTheSameDestinationAndOrigin(){
		
		welcome = new IndexPage(driver);
		
		welcome.EnterCredentials("rfqt28", "123456");
		
		findFlight = new FlightFinder(driver);
		
		actualTitle = findFlight.searchFlightSameDestiny("Frankfurt", "Frankfurt");
		
		Assert.assertFalse(actualTitle.equals("Find a Flight: Mercury Tours: "));
	
	}
	
	@AfterTest
	public void quit(){
	
		driver.close();
	
	}
	

}
