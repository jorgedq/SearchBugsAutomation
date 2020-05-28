package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {
	

	public FlightConfirmationPage(WebDriver driver) {
		
		this.driver=driver;
	
		PageFactory.initElements(driver, this);
	
	}
	
	public boolean isDisplayed() {
		
		return banner.isDisplayed();
	
	}
	
	public boolean codeDisplayed() {
		
		return fontsWhite.get(0).isDisplayed();
	
	}
	
	public String getPrice() {
		
		return generatePrice(price.get(11).getText());
		
	}
	
	private String generatePrice(String text) {
		
		String respuesta = "";
		
		boolean termino = false;
		
		for(int i = 0; i<text.length();i++){
		   
			if(!termino) {
			   
			   if(text.charAt(i) == ' ') {
					
				   termino = true;
					
			   }else {
				   
				   respuesta = respuesta + text.charAt(i);
			   }
			   
		   }
			
		}
		
		return respuesta;
		
	}
	
	WebDriver driver;
	
	@FindBy(xpath = ".//img[@src='/images/masts/mast_confirmation.gif']")
	private WebElement banner;
	
	@FindBy(xpath = ".//font[@color='#FFFFFF']")
	private List<WebElement> fontsWhite;
	
	@FindBy(xpath = ".//font[@face='Arial, Helvetica, sans-serif']")
	private List<WebElement> price;
	
}
