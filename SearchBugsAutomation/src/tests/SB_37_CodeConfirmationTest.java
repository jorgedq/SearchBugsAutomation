package tests;

import org.testng.annotations.Test;

import pages.BookAFlight;
import pages.FlightConfirmationPage;
import pages.FlightFinder;
import pages.IndexPage;
import pages.SelectFlight;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class SB_37_CodeConfirmationTest {
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver","./Drivers/Windows83/chromedriver.exe");					
	  
	  driver = new ChromeDriver();					  									
	  
	  driver.get(baseUrl);
	  
  }
  @Test
  public void f() throws InterruptedException {
	  
	  boolean codeExists = false;
		
		onMonth="4";
		
		onDay="13";
		
		returningMonth="5";
		
		returningDay="13";
		
		arrivingIn="Paris";
		
		signInPage = new IndexPage(driver);		
		
		signInPage.EnterCredentials("jorgedq", "12345");
		
		signInPage.LogInRedirectFlightsPage();
		
		Thread.sleep(2000);
		
		flightFinder=new FlightFinder(driver);
		
		if(flightFinder.isPageDisplayed()) {
		
			flightFinder.initialDate(onMonth,onDay);
			
			flightFinder.selectArrivingIn(arrivingIn);
			
			flightFinder.returnSelects(returningMonth,returningDay);
			
			flightFinder.continueButton();
			
			Thread.sleep(2000);
			
			selectflight=new SelectFlight(driver);
			
			if(selectflight.isDisplayed()) {
			
				selectflight.submit();
				
				Thread.sleep(2000);
				
				bookAFlight = new BookAFlight(driver);
				
				if(bookAFlight.isDisplayed()) {
				
					bookAFlight.fillData("Jorge", "Delgadillo", "1234567");
					
					bookAFlight.securePurchase();
					
					Thread.sleep(3000);
					
					pageConfirmation = new FlightConfirmationPage(driver);
					
					if(pageConfirmation.isDisplayed()) {
					
						if(pageConfirmation.codeDisplayed()) {
						
							codeExists = true;
						
						}
					
					}
				
				}
			}
		    
			AssertJUnit.assertEquals(codeExists, true);
		}
  }
  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  
  }
  
  String baseUrl = "http://newtours.demoaut.com/mercurywelcome.php";
	 
  public WebDriver driver;
	 
  private IndexPage signInPage;
	 
  private FlightConfirmationPage pageConfirmation;
  
  private FlightFinder flightFinder;
  
  private SelectFlight selectflight;
  
  private BookAFlight bookAFlight;
  
  private String onMonth;
  
  private String onDay;
  
  private String returningMonth;
  
  private String returningDay;
  
  private String arrivingIn;
}
