package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.Browser;
import objectRepository.FlightPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.MenuPage;
import objectRepository.RegistrationPage;

public class LoginPageTest {

	WebDriver driver;
	HomePage homePage;
	MenuPage menuPage;
	LoginPage loginPage;
	RegistrationPage registraionPage;
	FlightPage flightPage;
	
	@BeforeMethod
	@Given("^I was located on the home page$")
	public void i_was_located_on_the_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		new Browser("Chrome");
		driver = Browser.driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String url = "http://newtours.demoaut.com/";
		driver.get(url);
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getTitle(driver), "Welcome: Mercury Tours");
		menuPage = new MenuPage(driver);
	}

	@Test
	@When("^I am logging in with \"(.*?)\" and \"(.*?)\"$")
	public void i_am_logging_in_with_and(String name, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = homePage.signOn();
		flightPage = loginPage.login(name, password);
	}

	@AfterMethod
	@Then("^I should get SIGN-OFF link$")
	public void i_should_get_SIGN_OFF_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			menuPage.signOff.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}