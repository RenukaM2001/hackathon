package TestCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobjects.UpcomingBikes;
//@Listeners(Utilities.ExtentReportManager.class)
public class TC003_UpcomingBikePage extends TC002_UsedCars {
	
	@Test(priority=6)
	void test6() throws IOException, InterruptedException {
		UpcomingBikes up=new UpcomingBikes(driver);
		up.filtermanufacturer();
	}
	@Test(priority=7)
	void test7() throws IOException, InterruptedException {
		UpcomingBikes up=new UpcomingBikes(driver);
		up.scrollToViewMore();
		up.displaybikedetails();
	}
	@Test(priority=8)
	void test8() throws IOException {
		UpcomingBikes up=new UpcomingBikes(driver);
		up.returntohomepage();
	}


}
