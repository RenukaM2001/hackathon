package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobjects.UsedCarsPage;

public class TC002_UsedCars extends TC001_HomePage {
	@Test(priority=3)
	void test3() throws IOException, InterruptedException {
		UsedCarsPage up = new UsedCarsPage(driver);
		up.displayPopularModels();
	}
	
	@Test(priority=4)
	void test4() throws IOException {
		UsedCarsPage up = new UsedCarsPage(driver);
		up.returnToHomePage();

	}

}
