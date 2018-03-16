package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Browser;
import objectRepository.FlightPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.MenuPage;
import objectRepository.RegistrationPage;

public class LoginLogout {

	WebDriver driver;
	HomePage homePage;
	MenuPage menuPage;
	LoginPage loginPage;
	RegistrationPage registraionPage;
	FlightPage flightPage;

	@BeforeClass
	public void beforeTest() {
		new Browser("Firefox");
		driver = Browser.driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String url = "http://newtours.demoaut.com/";
		driver.get(url);
		homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getTitle(driver), "Welcome: Mercury Tours");
		menuPage = new MenuPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterMethod
	public void afterTest() {
		System.out.println(">>>>>>>>>>> after method >>>>>>>>>>");

	}

	// login test with correct user name and password
	@Test(dataProvider = "correctCredencials")
	public void testingWithCorrectCredencials(String name, String password) {
		// write your code over here
		loginPage = homePage.signOn();
		flightPage = loginPage.login(name, password);
		try {
			menuPage.signOff.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	// data provider for correct user name and password
	@DataProvider
	public Object[][] correctCredencials() {
		return new Object[][] { new Object[] { "a", "a" }, new Object[] { "b", "b" },

		};

	}

	// login test with incorrect user name and password
	@Test(dataProvider = "incorrectCredencials")
	public void testingWithIncorrectCredencials(String name, String password) throws InterruptedException {
		// write your code over here
		loginPage = homePage.signOn();
		flightPage = loginPage.login(name, password);
		try {
			menuPage.signIn.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			menuPage.signOff.click();
			Assert.fail();
		}
	}

	// data provider for incorrect user name and password
	@DataProvider
	public Object[][] incorrectCredencials() {

		return new Object[][] { new Object[] { "wrongemail", "incorrectpassword" },
				new Object[] { "incorrectemail", "wrongpassword" },

		};

	}

}
