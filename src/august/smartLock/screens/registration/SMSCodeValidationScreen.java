package august.smartLock.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The SMSCodeValidationScreen class will receives code sent to the user via SMS
 */
public class SMSCodeValidationScreen extends ScreenObject{
	
	/**
	 * By locator to find the Code input
	 */
	By byCodeField = By.id("signup_flow_enter_phone_code_field");
	
	/**
	 * By locator to find the Continue button	
	 */
	By byContinue = By.name("Continue");

	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public SMSCodeValidationScreen(AppiumDriver d)
	{
		super(d);
	}
	
	/**
	 * Click on the Continue button
	 */
	public void clickOnContinue()
	{
		this.click(byContinue, "Continue");
	}
	
	/**
	 * 
	 */
	public void waitForCode()
	{
		//byCodeField
		WebDriverWait waiter = new WebDriverWait(driver, 900, 20000);
		waiter.until(new ExpectedCondition<Boolean>(){
		            public Boolean apply(WebDriver d) {
		            	String codeSent = d.findElement(byCodeField).getText();
		                return (codeSent.length() == 6 && !(codeSent.compareTo("Enter Code") == 0));
		                		 
		            }});
		
	}
}
