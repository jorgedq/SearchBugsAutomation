package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAFlight {
	
	@FindBy(xpath = ".//*[@class='frame_header_info'][@colspan='2']")
	private WebElement on;
	@FindBy(xpath = ".//*[@class='data_center_mono'][@colspan='2']")
	private WebElement returning;
	@FindBy(name = "passFirst0")
	private WebElement firstName;
	@FindBy(name = "passLast0")
	private WebElement lastName;
	@FindBy(name = "creditnumber")
	private WebElement creditNumber;
	@FindBy(name = "buyFlights")
	private WebElement securePurchase;
	@FindBy(xpath = ".//img[@src='/images/masts/mast_book.gif']")
	private WebElement banner;
	@FindBy(xpath = ".//font[@face='Arial, Helvetica, sans-serif']//b")
	private List<WebElement> price;
	
	WebDriver driver;
	private String depart;
	private String retrn;
	public BookAFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		depart=on.getText();
		retrn=returning.getText();
	}
	public boolean ElementDateOn(String onM,String onD) {
		boolean res=depart.contentEquals(onM+"/"+onD+"/"+"2020");
		//System.out.println(res);	
		return res;
	}
	public boolean ElementDateReturning(String reM,String reD) {
		boolean res=retrn.contentEquals(reM+"/"+reD+"/"+"2020");
		//System.out.println(res);	
		return res;
	}
	
	public boolean isDisplayed() {
		return banner.isDisplayed();
	}
	public void fillData(String name,String lastname,String creditCard) {
		firstName.clear();
		lastName.clear();
		creditNumber.clear();
		firstName.sendKeys(name);
		lastName.sendKeys(lastname);
		creditNumber.sendKeys(creditCard);
	}
	public void securePurchase() {
		securePurchase.click();
	}
	
	public String getPrice() {
		
		return price.get(0).getText();
	
	}
}
