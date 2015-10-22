package august.smartLock.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The UserDetailsScreen class will receives the code sent via Email 
 */
public class EmailCodeValidationScreen extends ScreenObject{
	
	/**
	 * By locator to find the email address input
	 */
	By byEmailField = By.id("signup_flow_enter_email_code_field");
		
	/**
	 * By locator to find the Continue button
	 */
	By byContinue = By.id("signup_flow_validate_email_code_continue_button");

	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public EmailCodeValidationScreen(AppiumDriver d)
	{
		super(d);
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
	
	/**
	 * Wait the code entered manually
	 */
	public void waitForCode()
	{
		//byCodeField
		WebDriverWait waiter = new WebDriverWait(driver, 900, 20000);
		waiter.until(new ExpectedCondition<Boolean>(){
		            public Boolean apply(WebDriver d) {
		            	String codeSent = d.findElement(byEmailField).getText();
		                return (codeSent.length() == 6 && !(codeSent.compareTo("Enter Code") == 0));
		                		 
		            }});
		
	}
	

}
