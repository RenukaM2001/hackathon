package pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.ExcelUtils;
import Utilities.Screenshots;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//div[@class='col-lg-12 pl-0']/ul/li[3]/a")
	public WebElement newBikes;
	
	@FindBy(xpath="//ul[@class='h-d-nav fnt-16 ']/li[3]/ul/li[5]/span")
	public WebElement upcomingBikes;
	
	@FindBy(xpath="//div[@class='col-lg-12 pl-0']/ul/li[7]/a")
	public WebElement usedCars;
	
	@FindBy(xpath="//div[@class='h-dd-r']/ul/li/span")
	public List<WebElement> usedcar_City;
	
	@FindBy(xpath="//div[@class='h-dd-r']/ul/li[4]/span")
	public WebElement chennai_City;
	
	@FindBy(xpath="//div[@id='forum_login_title_lg']")
	public WebElement loginSignUp;
	
	@FindBy(xpath="//div[contains(@class,'googleSignIn')]")
	public WebElement googleBtn;
	
	@FindBy(xpath="//div[@class='aCsJod oJeWuf']/div/div[1]/input[@type='email']")
	public WebElement email;
	
	@FindBy(xpath="//span[@class='VfPpkd-vQzf8d' and text()='Next']")
	public WebElement nextBtn;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	public WebElement warning;
	
	public String title = driver.getTitle();
	
	public String homePage_WindowId = driver.getWindowHandle();
	
	//Action methods
	
	public void titleValidation() throws IOException {
		Screenshots ss = new Screenshots(driver);
		ss.ScreenShot("HomePage");
		Assert.assertEquals(title, "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com");
	}
	
	public void login() throws InterruptedException, IOException {
		Screenshots ss = new Screenshots(driver);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arugments[0].click();", loginSignUp);
		highlightElement(loginSignUp);
		loginSignUp.click();
		Thread.sleep(2000);
		ss.ScreenShot("LoginSignUp");
//		Thread.sleep(1000);
		googleBtn.click();
		Set<String> windowIds = driver.getWindowHandles();
		for(String s: windowIds) {
			if(!s.equalsIgnoreCase(homePage_WindowId)) {
				driver.switchTo().window(s);
				break;
			}
		}
		email.sendKeys(p.getProperty("emailid"));
		nextBtn.click();
		Thread.sleep(2000);
		ss.ScreenShot("googleSignIn");
	}
	
	public void captureErrorMessage() throws IOException {
		Screenshots ss = new Screenshots(driver);
		String xlFile = System.getProperty("user.dir")+"\\testData\\zigWheels.xlsx";
		highlightElement(warning);
		System.out.println(warning.getText());
		ExcelUtils.setCellData(xlFile, "warningMessage", 1, 0,warning.getText());
	}
	
	public void clickingOnUpcomingBikes() throws IOException {
		Screenshots ss = new Screenshots(driver);
		Actions act = new Actions(driver);
		act.moveToElement(newBikes).perform();
		highlightElement(upcomingBikes);
		ss.ScreenShot("upComingBikes");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(upcomingBikes));
		upcomingBikes.click();
	}
	
	public void clickingOnCityForUsedCars() throws IOException, InterruptedException {
		Screenshots ss = new Screenshots(driver);
		Actions act = new Actions(driver);
		act.moveToElement(usedCars).perform();
		for(WebElement e:usedcar_City) {
			if(e.getText().equalsIgnoreCase(p.getProperty("city"))) {	
				Thread.sleep(3000);
				highlightElement(chennai_City);
				ss.ScreenShot("clickingOnChennai");
				e.click();
				break;
			}
		}
	}
}

