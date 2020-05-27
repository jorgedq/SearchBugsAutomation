package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
  public class SelectFlight
  {
	  @FindBy(xpath = ".//*[@name='reserveFlights']")
	  private WebElement continuie;
	  WebDriver driver;
	 
     public SelectFlight( WebDriver driver){
	     this.driver=driver; 
	     PageFactory.initElements(driver, this);	    
      }
     public BookAFlight fecha(){
    	 continuie.click();
    	 return new BookAFlight(driver);
     }  
     
  }

