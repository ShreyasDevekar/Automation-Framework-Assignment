package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import tests.BaseTest;


public class Utility extends FetchElement
{
	/* Description: This method loads the property file. 
	 * Created By: Shreyas Devekar
	 * Parameters : propertyFilePath - property file path
	 */
	
	public Properties LoadProperties(String propertyFilePath) 
	{
		Properties prop = new Properties();
		try
		{
			FileInputStream inputFile = new FileInputStream(propertyFilePath);
			prop.load(inputFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		return prop;
	}
	
	/* Description: This method generates random value and passes to the element.
	 * Created By: Shreyas Devekar 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void getRandomValue(String locatorType, String locatorValue)
	{
		try 
		{
			Random random = new Random();
			int randomValue = random.nextInt(getElements(locatorType, locatorValue).size());
			getElements(locatorType, locatorValue).get(randomValue).click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Unable to select random value");
			Assert.assertTrue(false);
		}
		
	}
	
}
