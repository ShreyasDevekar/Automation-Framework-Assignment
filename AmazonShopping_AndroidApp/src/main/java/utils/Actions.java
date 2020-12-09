package utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import tests.BaseTest;

public class Actions extends FetchElement
{
	Properties prop = new Properties();
	WebDriverWait wait;
	
	/* Description: This method waits until the element is enabled for clicking. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void waitUntilElementIsClickable(String locatorType, String locatorValue)
	{
		try
		{
			wait=new WebDriverWait(BaseTest.driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(getBySelector(locatorType, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not clickable");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}

	}
	
	/* Description: This method waits until the element is visible. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void waitForElementToBeVisible(String locatorType, String locatorValue)
	{
		try
		{
			wait=new WebDriverWait(BaseTest.driver, 80);
			wait.until(ExpectedConditions.presenceOfElementLocated(getBySelector(locatorType, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not visible");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}

	}
	
	/* Description: This method sends the string input to text field. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 *              value - input value.
	 */

	public void inputString(String locatorType, String locatorValue, String value)
	{
		try 
		{
			click(locatorType, locatorValue);
			getElement(locatorType, locatorValue).clear();
			getElement(locatorType, locatorValue).sendKeys(value);

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Value unable to enter");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	/* Description: This method fetches the element text. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */

	public String getElementText(String locatorType,String locatorValue)
	{
		try 
		{
			waitForElementToBeVisible(locatorType, locatorValue);
			String text = getElement(locatorType, locatorValue).getText();
			return text;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			ReportGeneration.logger.info("Element does not exist");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}
		return null;
	}
	
	/* Description: This method validates that the one string contains another string or not. 
	 * Parameters : str1 - 1st string value
	 *              str2 - 2nd string value.
	 */
	
	public boolean stringContains(String str1, String str2)
	{
		if(str1.contains(str2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Description: This method presses enter key on android.
	
	public void pressEnter()
	{
		BaseTest.driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	// Description: This methods scrolls down the screen till last element.
	
	public static void scrollDown()
	{
		Dimension dimension = BaseTest.driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) BaseTest.driver).press(PointOption.point(0,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd)).release().perform();
	}
	
	/* Description: This method scrolls the screen till the required element is visible on screen. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void scrollTillElementVisible(String locatorType, String locatorValue)
	{
		boolean status = isElementPresent(locatorType, locatorValue);
		while(!status)
		{
			scrollDown();
			status = isElementPresent(locatorType, locatorValue);
			
		}
		
	}
	
	/* Description: This method scrolls screen till element is visible and clicks on it. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void scrollAndClick(String locatorType, String locatorValue)
	{
		scrollTillElementVisible(locatorType, locatorValue);
		click(locatorType, locatorValue);
	}
	
	/* Description: This method scroll till the input text is found and clicks on it.
	 * Parameters : visibleText - text to be search.
	 */

	public void scrollAndClickByText(String visibleText) 
	{
		try 
		{
			BaseTest.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not visible");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	/* Description: This method returns true or false based on element is present or not. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public boolean isElementPresent(String locatorType, String locatorValue)
	{
		try 
		{
			if(getElement(locatorType, locatorValue)!=null)
			{
				return true;
			}
			else
			{
				return false;
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/* Description: This method performs click operation. 
	 * Parameters : locatorType - locator type of element.
	 *              locatorValue - locator value of element.
	 */
	
	public void click(String locatorType, String locatorValue)
	{
		try 
		{
			waitUntilElementIsClickable(locatorType, locatorValue);
			getElement(locatorType, locatorValue).click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ReportGeneration.logger.info("The element is not clickable");
			ReportGeneration.logger.info("Cause: "+e.getCause()+", "+"Message: "+e.getMessage());
			Assert.assertTrue(false);
		}	
	}
	
	// Description: This method performs navigate to back action.
	
	public void clickBackButton() 
	{
		BaseTest.driver.navigate().back(); 
	}
	
	// Description: This method returns current rotation of screen.
	
	public ScreenOrientation GetCurrentRotation()
    {
        ScreenOrientation currentRotation = BaseTest.driver.getOrientation();
        return currentRotation;
    }
	
	// Description: This method sets rotation to portrait.
	
	public void SetRotationPortrait()
    {
        BaseTest.driver.rotate(ScreenOrientation.PORTRAIT);
    }
	
	// Description: This method sets rotation to landscape.

	public void SetRotationLandscape()
	{

		BaseTest.driver.rotate(ScreenOrientation.LANDSCAPE);
	}


}
