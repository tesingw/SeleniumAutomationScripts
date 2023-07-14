package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.logging.Logger;

public class BaseTest {

	private static WebDriver driver;
	public static Logger logger = Logger.getLogger(BasePage.class.getName());
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browserName")
	public void InitializeTestCase(String initializeBrowser) {
		initializeTheSelectedBrowser(initializeBrowser);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		report.endTest(test);
		driver.quit();
	}

	@BeforeClass(alwaysRun = true)
	public void initializeExtentReport() {
		report = new ExtentReports(
				System.getProperty("user.dir") + "\\" + "OutputExtentReport" + "\\" + "ProjectReport.html");
	}

	@AfterClass(alwaysRun = true)
	public void closeReport() {
		report.flush();
		report.close();
	}

	public void initializeTheSelectedBrowser(String browserName) {
		logger.info(String.valueOf(Thread.currentThread().getId()));
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	public static WebDriver initializeDriver() {
		return driver;
	}
}