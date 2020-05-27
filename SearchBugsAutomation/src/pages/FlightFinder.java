package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class FlightFinder {
			@FindBy(xpath = ".//*[@name='fromMonth']")
			private WebElement onMonth;
			@FindBy(xpath = ".//*[@name='fromDay']")
			private WebElement onDay;
			@FindBy(xpath = ".//*[@name='toMonth']")
			private WebElement returningMonth;
			@FindBy(xpath = ".//*[@name='toDay']")
			private WebElement returnigDay;
			@FindBy(xpath = ".//*[@name='findFlights']")
			private WebElement contine;
	        WebDriver driver;
	        Select selectOnMont;
	        Select selectOnDay;
	        Select selectReturnMounth;
	        Select selectReturnDay;
		public FlightFinder(WebDriver driver) {
		    this.driver=driver;
		    PageFactory.initElements(driver, this);
		    selectOnMont=new Select (onMonth);
		    selectOnDay=new Select (onDay);
		    selectReturnMounth=new Select (returningMonth);
		    selectReturnDay=new Select (returnigDay);
		}

	    public SelectFlight EnterOn(String onM,String onD ) {
	    	selectOnMont.selectByValue(onM);
	    	selectOnDay.selectByVisibleText(onD);
	    	contine.click();
	    	return new SelectFlight(driver);
	    }  
	    public SelectFlight EnterReturn(String returnM,String returnD ) {
	    	selectReturnMounth.selectByValue(returnM);
	    	selectReturnDay.selectByVisibleText(returnD);
	    	contine.click();
	    	return new SelectFlight(driver);
	    }  
}
