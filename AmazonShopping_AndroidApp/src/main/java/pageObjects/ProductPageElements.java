package pageObjects;

public interface ProductPageElements 
{
	// elements of product page. 
	
	String productDescription = "//*[@resource-id='title_feature_div']//*[@class='android.view.View']";
	String addToCartButton = "//*[contains(@resource-id,'add-to-cart-button')]";
	String goToCartButton = "//android.widget.ImageView[@content-desc=\"Cart\"]";
	
	
}
