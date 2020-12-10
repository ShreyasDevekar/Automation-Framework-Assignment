package pageEvents;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import pageObjects.ProductPageElements;
import utils.Actions;
import utils.ReportGeneration;
import utils.Utility;

public class ProductPageEvents extends Actions
{
	// Creation of Utility object to use utilities.
	
	Utility utils = new Utility();

	/* Description: This method returns selected product details.
	 * Created By: Shreyas Devekar 
	 */
	
	public String getProductDetails() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		//clickBackButton();
		ReportGeneration.logger.log(Status.INFO,"Fetching product details", putScreenshot());
		String description = getElementText("xpath",ProductPageElements.productDescription);
		ReportGeneration.logger.log(Status.INFO,"Product Details fetch successfully", putScreenshot());
		return description;
	}
	
	/* Description: This method adds selected product to cart.
	 * Created By: Shreyas Devekar
	 */
	
	public void addToCart() throws IOException
	{
		scrollAndClick("xpath", ProductPageElements.addToCartButton);
		ReportGeneration.logger.log(Status.INFO,"Adding product into the cart", putScreenshot());
	}
	
	/* Description: This method navigates to cart.
	 * Created By: Shreyas Devekar
	 */
	
	public void goToCart() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		ReportGeneration.logger.log(Status.INFO,"Navigating to cart", putScreenshot());
		clickBackButton();
		click("xpath", ProductPageElements.goToCartButton);
	}
}


