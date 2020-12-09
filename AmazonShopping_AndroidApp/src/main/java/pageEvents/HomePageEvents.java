package pageEvents;

import pageObjects.HomePageElements;
import utils.Actions;
import utils.Constants;
import utils.ExcelUtils;
import utils.Utility;

public class HomePageEvents extends Actions
{
	/*creation of utility object to access utilities.
	 * creation of ExcelUtils object to take test data from .xlsx file.
	 */
	Utility utils = new Utility();
	ExcelUtils excelData = new ExcelUtils(Constants.testDataFilePath,Constants.sheetName);

	// Description: This method takes product to search in application. 
	  
	public void searchProduct()
	{
		waitForElementToBeVisible("id", HomePageElements.searchProduct);
		inputString("id", HomePageElements.searchProduct,excelData.getStringCellData(1,1));
		pressEnter();
	}
}
