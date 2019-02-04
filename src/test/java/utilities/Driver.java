package utilities;

import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners
public class Driver {
	WebDriver driver;
	SoftAssert assertion = new SoftAssert();
	///////TODO : Logger log = new Logger
		
	@BeforeTest
	@Parameters("browserName")
	public void openBrowser(String browserName) {

		switch (browserName.toUpperCase()) {
		
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "IE":
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		
		case "SAFARI":
			System.setProperty("webdriver.safari.driver", "C:\\Users\\ekanshi.singhal\\eclipse-workspace\\automate\\drivers\\Safari.exe");
			driver = new SafariDriver();
			break;
		
//		case "HTMLUNIT": // or PHANTOMJS
//			System.setProperty("webdriver.chrome.driver", ".\\drivers\\IEDriverServer.exe");
//			HtmlUnitDriver unitDriver = new HtmlUnitDriver();
//			break;
		
		default: System.out.println("Can not identify the browser type. Valid options are : CHROME / FIREFOX / IE / SAFARI / HTMLUNIT ");
		
		System.out.println("started " + browserName+ " driver");
		}
		
		driver.manage().window().maximize();
	}

	@Test(description = "opening gmail")
	public void openGmail() throws InterruptedException {
		String gmailUrl = "https://www.google.com/intl/en-GB/gmail/about/#";
		driver.get(gmailUrl);
		Thread.sleep(5000);
		
		String actualTitle = driver.getTitle();
		System.out.println("title is : " + actualTitle);
		boolean doesTitleMatch = Pattern.compile(Pattern.quote("gmail"), Pattern.CASE_INSENSITIVE).matcher(actualTitle).find();

		//assertion.assertTrue(doesTitleMatch, "---Expected title:Gmail---But---Actual Title:" + driver.getTitle() + "---");
		 Assert.assertTrue(doesTitleMatch, "---Expected title:Gmail---But---Actual Title:" + driver.getTitle() + "---");
		
		System.out.println("launched gmail");
	}

//	@AfterTest
//	public void postActions() {
//		assertion.assertAll();
//	}

	@AfterClass
	public void closeBrowser() {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		System.out.println(driver.toString());		
		driver.quit();
		
		driver = null;
		System.out.println("closed the driver");
	}
}
