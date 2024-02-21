package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import Utilities.Screenshots;
import pageobjects.HomePage;

public class TC001_HomePage extends BaseClass {
	@Test(priority=1)
	void test1() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.titleValidation();
	}
	
	@Test(priority=2)
	void test2() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickingOnCityForUsedCars();
	}
	
	@Test(priority=5)
	void Test5() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.clickingOnUpcomingBikes();
	}
	
	@Test(priority=9)
	void Test9() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.login();
		hp.captureErrorMessage();
	}
}
