package testCases;

import org.openqa.selenium.WebDriver;

import objectRepository.Browser;
import objectRepository.RegistrationPage;

public class RegistrationTest {

	public static void main(String[] args) {
		// check registration page is working or not
		Browser b = new Browser("Firefox");
		WebDriver driver = b.driver;

		RegistrationPage r = new RegistrationPage(driver);

		r.autoFill("FirstName", "LastName", "email@somewhere.pom");

	}
}
