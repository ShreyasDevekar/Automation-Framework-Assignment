package pageEvents;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.Status;

import pageObjects.HomePageElements;
import utils.Actions;
import utils.Constants;
import utils.ExcelUtils;
import utils.ReportGeneration;
import utils.Utility;

public class HomePageEvents extends Actions
{
	/*creation of utility object to access utilities.
	 * creation of ExcelUtils object to take test data from .xlsx file.
	 */
	Utility utils = new Utility();
	ExcelUtils excelData = new ExcelUtils(Constants.testDataFilePath,Constants.sheetName);

	/* Description: This method takes product to search in application.
	 * Created By: Shreyas Devekar 
	 */
	  
	public void searchProduct() throws IOException
	{
		waitForElementToBeVisible("id", HomePageElements.searchProduct);
		inputString("id", HomePageElements.searchProduct,excelData.getStringCellData(1,1));
		ReportGeneration.logger.log(Status.INFO,"Searching product", putScreenshot());
		pressEnter();
	}
}
