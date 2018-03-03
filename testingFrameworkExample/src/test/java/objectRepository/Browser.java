package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver driver;

	public Browser(String browserName) {
		if (browserName == "Chrome") {
			driver = new ChromeDriver();

		} else if (browserName == "Firefox") {
			driver = new FirefoxDriver();

		} else {
			System.out.println("Chrome | Firefox");
		}

	}

}
