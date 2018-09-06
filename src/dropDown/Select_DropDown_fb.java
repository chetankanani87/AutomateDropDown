package dropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Select_DropDown_fb {
	WebDriver driver;

	@BeforeTest
	public void invokeBrowser() {

		System.setProperty("webdriver.gecko.driver", "C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}

	@Test
	public void SelectDDValues() {

		WebElement month_dropdown, day_dropdown, year_dropdown;
		Select month_dd, day_dd, year_dd;

		try {
			// WebElement to inspect a particular object
			month_dropdown = driver.findElement(By.id("month"));
			month_dd = new Select(month_dropdown);
			// It will select April
			month_dd.selectByIndex(4);

			day_dropdown = driver.findElement(By.id("day"));
			day_dd = new Select(day_dropdown);
			// It will select September
			day_dd.selectByValue("9");

			year_dropdown = driver.findElement(By.id("year"));
			year_dd = new Select(year_dropdown);
			// Highly recommended - It will select June
			year_dd.selectByVisibleText("1973");
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
