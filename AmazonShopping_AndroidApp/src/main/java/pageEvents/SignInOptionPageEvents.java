package pageEvents;

import pageObjects.SignInOptionPageElements;
import utils.Actions;

public class SignInOptionPageEvents extends Actions
{	
	/* Description: This method clicks on sign in button.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickOnSignIn() 
	{
		attachScreenshots("Clicking on Sign In");
		click("id", SignInOptionPageElements.signInButton_id);
	}
	
	/* Description: This method clicks on create account button.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickOnCreateAccount() 
	{
		attachScreenshots("Clicking on Create Account");
		click("id", SignInOptionPageElements.createAnAccountButton_id);
	}
	
	/* Description: This method clicks on skip sign in button.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickOnSkipSignIn() 
	{
		waitForElementToBeVisible("id",SignInOptionPageElements.skipSignInButton_id);
		attachScreenshots("Clicking on Skip Sign In");
		click("id", SignInOptionPageElements.skipSignInButton_id);
	}
	
	/* Description: This method clicks on language button for switching to local language.
	 * Created By: Shreyas Devekar
	 */
	
	public void switchToLocalLanguage() 
	{
		attachScreenshots("Clicking on Switch to local language");
		click("id", SignInOptionPageElements.localLanguageSelectOption_id);
	}

}
