package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAFlight {
	
	@FindBy(xpath = ".//*[@class='frame_header_info'][@colspan='2']")
	private WebElement on;
	@FindBy(xpath = ".//*[@class='data_center_mono'][@colspan='2']")
	private WebElement returning;
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
}
