package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// constructor that run by the time you call Home page class
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "SIGN-ON")
	public WebElement signOn;

	@FindBy(linkText = "REGISTER")
	public WebElement register;
	@FindBy(linkText = "CONTACT")
	public WebElement contact;

	// takes your driver and returns you the current title of the page
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public RegistrationPage register() {
		register.click();
		return new RegistrationPage(driver);

	}

	// method for filling login page
	public LoginPage signOn() {
		signOn.click();
		return new LoginPage(driver);
	}

	public ContactPage contact() {
		contact.click();
		return new ContactPage(driver);
	}

}
