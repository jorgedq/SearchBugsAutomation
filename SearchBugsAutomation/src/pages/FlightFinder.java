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
	@FindBy(xpath = ".//img[@src='/images/masts/mast_flightfinder.gif']")
	private WebElement banner;
	@FindBy(xpath = ".//*[@name='fromPort']")
	private WebElement deptFrom;
	@FindBy(xpath = ".//*[@name='toPort']")
	private WebElement arrivingIn;
	WebDriver driver;
	Select selectOnMont;
	Select selectOnDay;
	Select selectReturnMounth;
	Select selectReturnDay;
	Select selectArrivingIn;
	Select departFromSelect;
	Select arrivingInSelect;

	public FlightFinder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		selectOnMont = new Select(onMonth);
		selectOnDay = new Select(onDay);
		selectReturnMounth = new Select(returningMonth);
		selectReturnDay = new Select(returnigDay);

		selectArrivingIn = new Select(arrivingIn);

		departFromSelect = new Select(deptFrom);
		arrivingInSelect = new Select(arrivingIn);

	}

	public SelectFlight EnterOn(String onM, String onD) {
		selectOnMont.selectByValue(onM);
		selectOnDay.selectByVisibleText(onD);
		contine.click();
		return new SelectFlight(driver);
	}

	public SelectFlight EnterReturn(String returnM, String returnD) {
		selectReturnMounth.selectByValue(returnM);
		selectReturnDay.selectByVisibleText(returnD);
		contine.click();
		return new SelectFlight(driver);

	}

	public boolean isPageDisplayed() {
		return banner.isDisplayed();
	}

	public void selectArrivingIn(String selection) {
		selectArrivingIn.selectByVisibleText(selection);
	}

	public void initialDate(String month, String day) {
		selectOnMont.selectByValue(month);
		selectOnDay.selectByVisibleText(day);
	}

	public void returnSelects(String month, String day) {
		selectReturnMounth.selectByValue(month);
		selectReturnDay.selectByVisibleText(day);
	}

	public void continueButton() {
		contine.click();
	}

	public String searchFlightSameDestiny(String origin, String destiny) {
		departFromSelect.selectByVisibleText(origin);
		arrivingInSelect.selectByVisibleText(destiny);
		contine.click();
		return driver.getTitle();
	}

	public String searchFlight(String origin, String monthOrigin, String dayOrigin, String destiny, String monthReturn,
			String dayReturn) {
		departFromSelect.selectByVisibleText(origin);
		selectOnMont.selectByVisibleText(monthOrigin);
		selectOnDay.selectByVisibleText(dayOrigin);
		arrivingInSelect.selectByVisibleText(destiny);
		selectReturnMounth.selectByVisibleText(monthReturn);
		selectReturnDay.selectByVisibleText(dayReturn);
		contine.click();
		return driver.getTitle();
	}

}
