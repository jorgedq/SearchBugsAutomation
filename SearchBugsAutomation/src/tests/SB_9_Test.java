package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FlightFinder;
import pages.IndexPage;

//Verify the flight search by entering a range of invalid dates
public class SB_9_Test {
	
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
	public void verifyFlightSearchEnteringInvalidDates(){
		welcome = new IndexPage(driver);
		welcome.EnterCredentials("rfqt28", "123456");
		findFlight = new FlightFinder(driver);
		actualTitle = findFlight.searchFlight("London", "October", "23", "Acapulco", "June", "11");
		Assert.assertFalse(actualTitle.equals("Find a Flight: Mercury Tours: "));
	}
	
	@AfterTest
	public void quit(){
		driver.close();
	}

}
