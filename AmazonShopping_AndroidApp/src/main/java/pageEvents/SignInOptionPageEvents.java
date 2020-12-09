package pageEvents;

import pageObjects.SignInOptionPageElements;
import utils.Actions;

public class SignInOptionPageEvents extends Actions
{
	// Description: This method clicks on sign in button.
	
	public void clickOnSignIn()
	{
		click("id", SignInOptionPageElements.signInButton_id);
	}
	
	// Description: This method clicks on create account button.
	
	public void clickOnCreateAccount()
	{
		click("id", SignInOptionPageElements.createAnAccountButton_id);
	}
	
	// Description: This method clicks on skip sign in button.
	
	public void clickOnSkipSignIn()
	{
		click("id", SignInOptionPageElements.skipSignInButton_id);
	}
	
	// Description: This method clicks on language button for switching to local language.
	
	public void switchToLocalLanguage()
	{
		click("id", SignInOptionPageElements.localLanguageSelectOption_id);
	}

}
