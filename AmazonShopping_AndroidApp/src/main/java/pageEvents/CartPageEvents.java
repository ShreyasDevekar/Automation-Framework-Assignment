package pageEvents;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pageObjects.CartPageElements;
import utils.Actions;
import utils.Constants;
import utils.ReportGeneration;

public class CartPageEvents extends Actions
{
	/* Description : This method returns the details of product present in cart.
	 * Created By: Shreyas Devekar
	 */
	public String getCartProductDetails() throws IOException
	{
		String cartProductDetails = getElementText("xpath",CartPageElements.productDescriptionInCart);
		ReportGeneration.logger.log(Status.INFO,"Fetching product details present in a cart", putScreenshot());
		return cartProductDetails;
	}
	
	/* Description: This method compares details of selected product and product present in cart. 
	 * Created By: Shreyas Devekar
	 * Parameters : selectedProductDetails - details of product selected to add in cart.
	 *              cartProductDetails - details of product present in cart.
	 */
	
	public void compareProductDetails(String selectedProductDetails,String cartProductDetails) throws IOException
	{
		StringTokenizer st=new StringTokenizer(cartProductDetails, "...");
		ReportGeneration.logger.log(Status.INFO,"Validating the selected product and cart product for checkout is same", putScreenshot());
		if(selectedProductDetails.contains(st.nextToken()))
		{
			ReportGeneration.logger.info("The product Details are matched");
		}
		else
		{
			ReportGeneration.logger.info("The product Details are not matching");
		}
	}

}
