package pageEvents;

import java.util.StringTokenizer;

import org.testng.Assert;

import pageObjects.CartPageElements;
import utils.Actions;
import utils.ReportGeneration;

public class CartPageEvents extends Actions
{
	// Description : this method returns the details of product present in cart.
	public String getCartProductDetails()
	{
		String cartProductDetails = getElementText("xpath",CartPageElements.productDescriptionInCart);
		return cartProductDetails;
	}
	
	/* Description: This method compares details of selected product and product present in cart. 
	 * Parameters : selectedProductDetails - details of product selected to add in cart.
	 *              cartProductDetails - details of product present in cart.
	 */
	
	public void compareProductDetails(String selectedProductDetails,String cartProductDetails)
	{
		StringTokenizer st=new StringTokenizer(cartProductDetails, "...");
		if(selectedProductDetails.contains(st.nextToken()))
		{
			Assert.assertTrue(true);
			ReportGeneration.logger.info("The product Details are matched");
		}
		else
		{
			Assert.assertTrue(false);
			ReportGeneration.logger.info("The product Details are not matching");
		}
				
	}

}
