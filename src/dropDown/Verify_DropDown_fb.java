package dropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Verify_DropDown_fb {
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
		WebElement month_dropdown, day_dropdown, year_dropdown, selected_val;
		Select month_dd, day_dd, year_dd;

		try {
			// WebElement to inspect month drop-down object
			month_dropdown = driver.findElement(By.id("month"));
			month_dd = new Select(month_dropdown);
			selected_val = month_dd.getFirstSelectedOption();
			// It should return already selected month
			System.out.println("Before Selection pre-selected value of Month drop-down is: " + selected_val.getText());

			// It will select April
			month_dd.selectByIndex(4);
			selected_val = month_dd.getFirstSelectedOption();
			// It should return April
			System.out.println("After Selection selected value of Month drop-down is: " + selected_val.getText());

			// WebElement to inspect day drop-down object
			day_dropdown = driver.findElement(By.id("day"));
			day_dd = new Select(day_dropdown);
			selected_val = day_dd.getFirstSelectedOption();
			// It should return already selected day
			System.out.println("Before Selection pre-selected value of Day drop-down  is: " + selected_val.getText());

			// It will select September
			day_dd.selectByValue("9");
			selected_val = day_dd.getFirstSelectedOption();
			// It should return April
			System.out.println("After Selection selected value of Day drop-down  is: " + selected_val.getText());

			// WebElement to inspect year drop-down object
			year_dropdown = driver.findElement(By.id("year"));
			year_dd = new Select(year_dropdown);
			selected_val = year_dd.getFirstSelectedOption();
			// It should return already selected year
			System.out.println("Before Selection pre-selected value of Year drop-down  is: " + selected_val.getText());

			// It will select 1973
			year_dd.selectByVisibleText("1973");
			selected_val = year_dd.getFirstSelectedOption();
			// It should return April
			System.out.println("After Selection selected value of Year drop-down  is: " + selected_val.getText());

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
