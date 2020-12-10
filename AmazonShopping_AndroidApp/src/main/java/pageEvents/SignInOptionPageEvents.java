package pageEvents;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import pageObjects.SignInOptionPageElements;
import utils.Actions;
import utils.ReportGeneration;

public class SignInOptionPageEvents extends Actions
{
	/* Description: This method clicks on sign in button.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickOnSignIn() throws IOException, InterruptedException
	{
		ReportGeneration.logger.log(Status.INFO,"Clicking on Sign In", putScreenshot());
		click("id", SignInOptionPageElements.signInButton_id);
	}
	
	/* Description: This method clicks on create account button.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickOnCreateAccount() throws IOException
	{
		ReportGeneration.logger.log(Status.INFO,"Clicking on Create Account", putScreenshot());
		click("id", SignInOptionPageElements.createAnAccountButton_id);
	}
	
	/* Description: This method clicks on skip sign in button.
	 * Created By: Shreyas Devekar
	 */
	
	public void clickOnSkipSignIn() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		ReportGeneration.logger.log(Status.INFO,"Clicking on Skip Sign In", putScreenshot());
		click("id", SignInOptionPageElements.skipSignInButton_id);
	}
	
	/* Description: This method clicks on language button for switching to local language.
	 * Created By: Shreyas Devekar
	 */
	
	public void switchToLocalLanguage() throws IOException
	{
		ReportGeneration.logger.log(Status.INFO,"Clicking on Switch to local language", putScreenshot());
		click("id", SignInOptionPageElements.localLanguageSelectOption_id);
	}

}
