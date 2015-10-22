package august.smartLock.screens.registration;

import org.openqa.selenium.By;  //used to find elements (by id, class, xpath etc)

import io.appium.java_client.AppiumDriver; 
/**
 * 
 * @author MakingSense QA Team
 * 
 * The YouAreInvitedScreen class is the first screen. This class redirect user to
 * the Sign In or Sign Up screen
 */

public class YouAreInvitedScreen extends ScreenObject{
	
	/**
	 * By locator to find the Create Account button
	 */
	By bySignIp = By.id("welcome_gate_create_account_text");
	
	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public YouAreInvitedScreen(AppiumDriver d)
	{
		super(d);
	}
	
	/*
	 * Click on the Create Account button
	 */
	public void clickOnCreateAccountButton()
	{	
		this.click(bySignIp, "Create Account");
	}

}
