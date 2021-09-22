package Page;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Utility.ExcelLibrary;
import Utility.Verification;

public class Bot {

	WebDriver driver;
	Verification verify;
	ExcelLibrary excel;
	Properties prop;

	public Bot(WebDriver driver, ExcelLibrary excel,Properties prop)
	{
		this.driver=driver;
		this.excel = excel;
		verify = new Verification(driver,excel);
		this.prop=prop;
	}

	By clickNotification = By.xpath("//img[contains(@class,'avm-bot-icon')]");
	By clickGetStartedButton = By.xpath("//*[contains(text(),'Get Started')]");
	By clickSwitchMenu = By.xpath("//*[contains(@class,'ptr clear-btn-defaults pointer botMenu__toggleEditor ')][1]");
	By typeMessage = By.id("queryTextbox");
	By clickSwitchMenuButton= By.xpath("//body[1]/main[1]/form[1]/div[1]/div[3]/button[1]");
	By clickStartOverButton = By.linkText("Start Over");
	By clickDownloadMotorPolicyLink = By.xpath("//div[@class='default_card_link']//a[contains(text(),'Download Motor Policy')]");
	By clickDownloadLink = By.xpath("//*[contains(text(),'Download')]");
	By enterNameIntoTextbox = By.xpath("//input[@class='textbox avm_accessible_txt_box_helper']");
	By enterAddressIntoTextbox = By.xpath("//textarea[@class='textbox avm_accessible_txt_box_helper']");
	By selectFemaleRadioButton = By.xpath("//span[@class='composer__container__preview__option__circle avm_poll_helper' and @aria-label='Female']");
	By clickSubmitButton = By.xpath("//button[text()='Submit' and @class='btn default_card_submit']");
	By clickSelectDropdown = By.xpath("//input[@class='textbox picklist-textbox avm_pick_list_input' and @placeholder='Select']");
	By selectRating = By.xpath("//label[contains(text(),'2')]");
	By clickGoogleLink = By.linkText("Google");
	By clickCloseIcon = By.xpath("//button[contains(text(),'×')]");
	By clickCallLink = By.linkText("Call");
	By botResponse = By.xpath("//div[@class='conversation-item clearfix not-mine'][last()]");


	public void clickIRABot() throws InterruptedException, IOException
	{
		verify.waiter(clickNotification, "Click On Notification", driver);
		int count= driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames are:" + count);
		verify.waiter(clickGetStartedButton, "Click On Get Started Button", driver);
		driver.switchTo().frame("avaamoIframe");
		System.out.println("Into Frame");
		verify.waiter(clickSwitchMenu, "Click On Switch Menu Button", driver);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance1"), Keys.ENTER);
		verify.botResponse(botResponse, prop.getProperty("Utterance1"), driver);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		/* You can uncomment the below scenario to make it pass */
		//	verify.waiter(clickSwitchMenuButton, "Click On Switch Menu Button again", driver);
		verify.waiter(clickStartOverButton, "Click On Start Over Button", driver);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		Thread.sleep(3000);
		verify.waiter(clickDownloadMotorPolicyLink, "Click on Download Motor Policy Link", driver);
		Thread.sleep(3000);
		verify.waiter(clickDownloadLink, "Click On Download Link", driver);
		Thread.sleep(3000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance2"), Keys.ENTER);
		driver.findElement(enterNameIntoTextbox).sendKeys(prop.getProperty("Utterance3"));		
		driver.findElement(enterAddressIntoTextbox).sendKeys(prop.getProperty("Utterance4"));			
		verify.waiter(selectFemaleRadioButton, "Click On Female radio Button", driver);	
		verify.waiter(clickSubmitButton, "Click On Submit Button", driver);
		verify.waiter(clickSelectDropdown, "Click On Select dropdown", driver);
		driver.findElement(clickSelectDropdown).sendKeys(prop.getProperty("Utterance5"), Keys.ENTER);
		verify.waiter(selectRating, "Selet Rating", driver);
		verify.waiter(clickSubmitButton, "Click On Submit Button", driver);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance6"), Keys.ENTER);
		Thread.sleep(3000);
		verify.botResponse(botResponse, prop.getProperty("Utterance6"), driver);
		Thread.sleep(4000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance7"), Keys.ENTER);
		Thread.sleep(3000);
		verify.botResponse(botResponse, prop.getProperty("Utterance7"), driver);
		Thread.sleep(4000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance8"), Keys.ENTER);
		Thread.sleep(3000);
		verify.botResponse(botResponse, prop.getProperty("Utterance8"), driver);
		Thread.sleep(4000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance9"), Keys.ENTER);
		Thread.sleep(3000);
		verify.botResponse(botResponse, prop.getProperty("Utterance9"), driver);
		Thread.sleep(4000);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Reset"), Keys.ENTER);
		driver.findElement(typeMessage).sendKeys(prop.getProperty("Utterance10"), Keys.ENTER);
		verify.waiter(clickGoogleLink, "Click Google Link", driver);
		verify.waiter(clickCloseIcon, "Click Google Link close icon", driver);
		verify.waiter(clickCallLink, "Click Call Link", driver);					
	}

}



