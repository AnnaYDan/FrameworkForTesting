package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {

	WebDriver driver;

	public FlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	public WebElement fName;

	@FindBy(css = "[type='radio'][value='oneway']")
	public WebElement oneWay;
	@FindBy(name = "fromPort")
	public WebElement fromPort;
	@FindBy(name = "toPort")
	public WebElement toPort;

	public void fillForm() {
		fName.sendKeys("FirstName");
		oneWay.click();
		fromPort.sendKeys("DC");
		toPort.sendKeys("France");

	}
}
