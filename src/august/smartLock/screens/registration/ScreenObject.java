package august.smartLock.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

/**
 * @author MakingSense QA Team
 * @desc This class will hold functions for user interaction. 
 * Include functions related to the softkeyboar as Done, Enter, Back
 * 
*/

public class ScreenObject {
	
	protected AppiumDriver driver;
	
	/**
	 * Constructor
	 * @param AppiumDriver d - Android driver
	 */
	public ScreenObject(AppiumDriver d)
	{
		driver = d;	
	}
	
	/**
	 * Click on the Done button of the softkeyboard
	 */
	public void Done()
	{
		driver.tap(1, 995, 1819,1);
	}
	
	/**
	 * Set a specified value to a element
	 * @param selector - By element to find the element which will receives the value
	 * @param fieldName - Label of the element
	 * @param value - Value to set the elemt
	 */
	public void sendKey(By selector, String fieldName, Object value)
	{
		try{
			driver.findElement(selector).sendKeys((String)value);
			System.out.println("Setting the " + fieldName+ " field...");
		}
		catch (NoSuchElementException e){
			System.out.println("The " + fieldName + " element was not found. See error: " + e.getMessage());
		}
	}
	
	/**
	 * Click on the specified element (button or link)
	 * @param selector - By element to find the element which will receives the value
	 * @param buttonText - Label of the element
	 */
	public void click(By selector, String buttonText)
	{
		{
			try{
				System.out.println("Clicking on the " +  buttonText + " button...");
				waitElement(selector);
				driver.findElement(selector).click();
			}
			catch (IndexOutOfBoundsException e){
				System.out.println("The " + buttonText + " button was not found. See error: " + e.getMessage());
			
			}
		}
	}
	
	/**
	 * Check if the locator given is displayed
	 * @param byPasswordErrorLocator locator to find the element
	 * @return
	 */
	public boolean isDisplayed(By byPasswordErrorLocator) {
	
		return ((driver.findElement(byPasswordErrorLocator)!= null)&&(driver.findElement(byPasswordErrorLocator).isDisplayed()));
	}
	
	/**
	 * Get the text of the element associated to the locator
	 * @param locator - locator
	 * @return Text of the WebElement
	 */
	public String getText(By locator)
	{
		this.waitElement(locator);
		return this.getElement(locator).getText();
	}
			
	/**
	 * Return the WebElemnt associated to the given locator
	 * @param elementLocator locator
	 * @return
	 */
	public WebElement getElement(By elementLocator)
	{
		this.waitElement(elementLocator);
		return driver.findElement(elementLocator);
	}
	
	/**
	 * Hide the soft keyboard
	 */
	public void hideKeyboard()
	{
		driver.hideKeyboard();
	}
	
	/**
	 * Wait until the specified element is present
	 * @param elementSelector - By element to find the element which will receives the value
	 */
	public void waitElement(final By elementSelector)
	{
		WebDriverWait waiter = new WebDriverWait(driver, 90, 1000);
		waiter.until(new ExpectedCondition<Boolean>(){
		            public Boolean apply(WebDriver d) {
		                return (d.findElement(elementSelector)!=null);
		            }});
	}
	
	
	
}
