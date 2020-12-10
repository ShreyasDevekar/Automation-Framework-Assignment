package pageEvents;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageObjects.ProductSearchResultPageElements;
import utils.Actions;
import utils.Constants;
import utils.ReportGeneration;
import utils.Utility;

public class ProductSearchResultPageEvents extends Actions
{
	// Creation of Utility object to use utilities.
	
	Utility utils = new Utility();
	
	/* Description: This method selects random product from search results.
	 * Created By: Shreyas Devekar
	 */
	
	public void selectRandomProductFromSearchResults() throws IOException
	{
		waitForElementToBeVisible("id", ProductSearchResultPageElements.searchProductResultList_id);
		ReportGeneration.logger.log(Status.INFO,"Selecting product from search results", putScreenshot());
		utils.getRandomValue("id", ProductSearchResultPageElements.searchProductResultList_id);
	}

}
