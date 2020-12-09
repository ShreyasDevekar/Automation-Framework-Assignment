package pageEvents;

import pageObjects.ProductSearchResultPageElements;
import utils.Actions;
import utils.Utility;

public class ProductSearchResultPageEvents extends Actions
{
	// Creation of Utility object to use utilities.
	
	Utility utils = new Utility();
	
	// Description: This method selects random product from search results.
	
	public void selectRandomProductFromSearchResults()
	{
		waitForElementToBeVisible("id", ProductSearchResultPageElements.searchProductResultList_id);
		utils.getRandomValue("id", ProductSearchResultPageElements.searchProductResultList_id);
	}

}
