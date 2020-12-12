package pageEvents;

import pageObjects.ProductSearchResultPageElements;
import utils.Actions;

public class ProductSearchResultPageEvents extends Actions
{
	/* Description: This method selects random product from search results.
	 * Created By: Shreyas Devekar
	 */
	
	public void selectRandomProductFromSearchResults()
	{
		waitForElementToBeVisible("id", ProductSearchResultPageElements.searchProductResultList_id);
		attachScreenshots("Selecting product from search results");
		getRandomValue("id", ProductSearchResultPageElements.searchProductResultList_id);
	}

}
