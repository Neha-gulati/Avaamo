package Utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verification {

	WebDriver driver;
	ExcelLibrary excel;

	public Verification(WebDriver driver, ExcelLibrary excel)
	{
		this.driver = driver;
		this.excel = excel;

	}

	public void waiter(By ele, String message, WebDriver driver) throws IOException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
			System.out.println(message + " Is clickable");
			excel.writeTestcases(message, " Is clickable", "Pass");
		}
		catch(Exception e)
		{
			System.out.println(message + " Is not clickable");
			excel.writeTestcases(message, " Is not clickable", "Fail");
			screenshot("./Screenshot/Failed_TestCase_"+message+".png", driver);
		}
	}

	public void deleteScreenshot()
	{
		File outputfolder=new File("./Screenshot");
		if(outputfolder.isDirectory()==true) {
			//Delete the files if Output folder and files exists.
			File[] listFiles = outputfolder.listFiles();
			for(File file : listFiles){
				System.out.println("Deleting "+file.getName());
				file.delete();
			}		
		}else {
			//Create Output folder if it does not exist
			outputfolder.mkdir();
		}
	}

	public void botResponse(By ele,String scenario, WebDriver driver) throws IOException
	{
		try
		{
			String response=	driver.findElement(ele).getText();
			System.out.println("Bot response is : " + response);
			excel.writeTestcases(scenario, response, "Pass");
		}
		catch(Exception e)
		{
			String response = "Null";
			excel.writeTestcases(scenario, response, "Fail");
			screenshot("./Screenshot/Failed_TestCase_"+scenario+".png", driver);
		}
	}

	public void screenshot(String fileWithPath, WebDriver driver) throws IOException
	{
		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination

		File DestFile=new File(fileWithPath);

		//Copy file at destination

		//FileUtils.copyFile(SrcFile, DestFile);
		FileHandler.copy(SrcFile, DestFile);

	}



}