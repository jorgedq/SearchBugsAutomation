package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.BookAFlight;
import pages.SelectFlight;
import pages.FlightFinder;

public class OnDate {
	String baseUrl = "http://newtours.demoaut.com/mercurywelcome.php";
	public WebDriver driver;
	private IndexPage signInPage;
    private FlightFinder flightFinder;
    private SelectFlight selectflight;
    private BookAFlight bookAFlight;
    private String month;
    private String day;
	@Test
	public void VerifyDateOninBookAFlight() {
		month="2";
		day="1";
		signInPage = new IndexPage(driver);		
		signInPage.EnterCredentials("gestionCalidad", "1234");
		flightFinder=new FlightFinder(driver);
		flightFinder.EnterOn(month,day);
		selectflight=new SelectFlight(driver);
		selectflight.fecha();
		bookAFlight=new BookAFlight(driver);
	     Assert.assertTrue(bookAFlight.ElementDateOn(month,day), "Message was not displayed");
	  }
	
	 @BeforeTest
	 public void setup() {
		System.setProperty("webdriver.chrome.driver","./Drivers/Windows83/chromedriver.exe");					
		driver = new ChromeDriver();					  									
		driver.get(baseUrl);
		
	}
	
     @AfterTest
     public void quit() {   	
      driver.close();	
}
    
}