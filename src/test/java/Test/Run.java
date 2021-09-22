package Test;

import org.testng.annotations.Test;
import Page.Bot;
import Utility.ExcelLibrary;
import Utility.Verification;

import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Run {
	public WebDriver driver;
	Bot b;
	ExcelLibrary excel;
	Properties prop;

	@Test
	public void verify_Bot() throws InterruptedException, IOException {
		b = new Bot(driver,excel,prop);
		b.clickIRABot();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		Verification verify = new Verification(driver,excel);
		verify.deleteScreenshot();
		excel = new ExcelLibrary();
		excel.createExcelSheet();
		prop=new Properties();
		FileInputStream fis=new FileInputStream("./Config/config.properties"); 
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://c6.avaamo.com/web_channels/444588bc-92fe-477f-87c1-88a92946346a/demo.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Test agent - IRA"));
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
