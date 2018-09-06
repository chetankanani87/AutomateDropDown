package dropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class Assert_DropDown_fb {
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
		List<WebElement> months_List, days_List, years_List;

		// WebElement to inspect a particular object
		month_dropdown = driver.findElement(By.id("month"));
		month_dd = new Select(month_dropdown);
		months_List = month_dd.getOptions();
		int total_months = months_List.size();
		Assert.assertEquals(total_months, 13);
		System.out.println("Total Month count is: " + total_months);
		System.out.println("Months are: ");
		for (WebElement ele : months_List) {
			System.out.println(ele.getText() + " ");
		}
		
		day_dropdown = driver.findElement(By.id("day"));
		day_dd = new Select(day_dropdown);
		days_List = day_dd.getOptions();
		int total_days = days_List.size();
		Assert.assertEquals(total_days, 32);
		System.out.println("Total Day count is: " + total_days);
		System.out.println("Days are: ");
		for (WebElement ele : days_List) {
			System.out.println(ele.getText());
		}

		year_dropdown = driver.findElement(By.id("year"));
		year_dd = new Select(year_dropdown);
		years_List = year_dd.getOptions();
		int total_years = years_List.size();
		Assert.assertEquals(total_years, 115);
		System.out.println("Total Year count is: " + total_years);
		System.out.println("Years are: ");
		for (WebElement ele : years_List) {
			System.out.println(ele.getText());
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
