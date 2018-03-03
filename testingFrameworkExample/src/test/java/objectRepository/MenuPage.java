package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

	WebDriver driver;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "SIGN-ON")
	public WebElement signIn;
	@FindBy(linkText = "REGISTER")
	public WebElement register;
	@FindBy(linkText = "SIGN-OFF")
	public WebElement signOff;

}
