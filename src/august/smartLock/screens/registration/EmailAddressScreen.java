package august.smartLock.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The EmailAddressScreen class will receives the email address of the user 
 */
public class EmailAddressScreen extends ScreenObject{
	
	/**
	 * By selector to find the Email address input
	 */
	By byEmailField = By.id("signup_flow_collect_email_field");
		
	/**
	 * By selector to find the Continue button
	 */
	By byContinue = By.id("signup_flow_enter_email_continue_button");

	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public EmailAddressScreen(AppiumDriver d)
	{
		super(d);
	}
	
	/**
	 * Set the email address in the email address field
	 * @param emailAddress Phone number to set in the email address field
	 */
	public void enterEmailAddress(String emailAddress)
	{
		this.sendKey(byEmailField, "Email Address", emailAddress);
	}
	
	/**
	 * Click on the Continue button
	 */
	public void clickOnContinue()
	{
		try{
			driver.findElement(byContinue).click();
		}
		catch (NoSuchElementException e){
			System.out.println("The 'Continue' element was not found. See error: " + e.getMessage());
		}
	}
	
}
