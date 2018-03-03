package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;

	public ContactPage(WebDriver driver) {
		// Initiating page factory for contact page
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "email")
	public WebElement email;
	@FindBy(id = "comment")
	public WebElement message;
	@FindBy(id = "submit")
	public WebElement submit;

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void sendMessage(String email, String message) {
		this.email.sendKeys(email);
		this.message.sendKeys(message);
		submit.click();

	}
}
