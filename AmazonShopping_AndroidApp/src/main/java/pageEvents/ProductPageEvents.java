package pageEvents;

import pageObjects.ProductPageElements;
import utils.Actions;
import utils.Utility;

public class ProductPageEvents extends Actions
{
	// Creation of Utility object to use utilities.
	
	Utility utils = new Utility();

	// Description: This method returns selected product details. 
	
	public String getProductDetails() throws InterruptedException
	{
		Thread.sleep(3000);
		clickBackButton();
		String description = getElementText("xpath",ProductPageElements.productDescription);
		return description;
	}
	
	// Description: This method adds selected product to cart.
	
	public void addToCart()
	{
		scrollAndClick("xpath", ProductPageElements.addToCartButton);
	}
	
	// Description: This method navigates to cart.
	
	public void goToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		clickBackButton();
		click("xpath", ProductPageElements.goToCartButton);
	}
}


