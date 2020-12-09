package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageEvents.CartPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.ProductPageEvents;
import pageEvents.ProductSearchResultPageEvents;
import pageEvents.SignInOptionPageEvents;
import utils.ReportGeneration;

public class SampleTest extends BaseTest
{
	// Description: This test case validates that the selected product and product present in the cart are same or not. 
	
	@Test
	public void demoTest() throws InterruptedException
	{
		SignInOptionPageEvents signIn = new SignInOptionPageEvents();
        ReportGeneration.logger.info("Clicking on skip sign in button");
		signIn.clickOnSkipSignIn();
		
		HomePageEvents homePage = new HomePageEvents();
		ReportGeneration.logger.info("Searching product");
		homePage.searchProduct();
		
		ProductSearchResultPageEvents searchResult = new ProductSearchResultPageEvents();
		ReportGeneration.logger.info("Selecting product from search results");
		searchResult.selectRandomProductFromSearchResults();
		
		ProductPageEvents productPage = new ProductPageEvents();
		ReportGeneration.logger.info("Fetching product details");
		String selectedProductDetails = productPage.getProductDetails();
		ReportGeneration.logger.info("Product Details fetch successfully");
		ReportGeneration.logger.info("Adding product into the cart");
		productPage.addToCart();		
		ReportGeneration.logger.info("Product added to cart successfully");
		ReportGeneration.logger.info("Navigating to cart");
		productPage.goToCart();
		
		CartPageEvents cartPage = new CartPageEvents();
		String cartProductDetails = cartPage.getCartProductDetails();
		ReportGeneration.logger.info("Validating the selected product and cart product for checkout is same");
		cartPage.compareProductDetails(selectedProductDetails, cartProductDetails);
	}

}
