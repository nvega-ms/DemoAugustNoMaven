package august.smartLock.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The UserDetailsScreen class will receives the FirstName, LastName and Password of the user 
 */
public class UserDetailsScreen extends ScreenObject {

	
	/**
	 * By locator to find the First Name input
	 */
	By byFirstName = By.id("signup_flow_first_name_field");
	
	/**
	 * By locator to find the Last Name input
	 */
	By byLastName = By.id("signup_flow_last_name_field");
	
	/**
	 * By locator to find the Password input
	 */
	By byCreatePassword = By.id("signup_flow_password_field");
	
	/**
	 * By locator to find the Password Strength error
	 */
	By byPasswordError = By.id("signup_flow_password_strength_container");
	
	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	
	public UserDetailsScreen(AppiumDriver d)
	{
		super(d);
		
	}
	
	/**
	 * Set First Name, Lst Name and Password fields
	 * @param firstName  Value to set the First Name field
	 * @param lastName Value to set the Last Name field
	 * @param Password Value to set the Password field
	 */
	public void setAllfields(String firstName, String lastName,  String password)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
	}
	
	/**
	 * Set the First Name input, with the given firstName parameter
	 * @param firstName  Value to set the First Name field
	 */
	public void setFirstName(String firstName)
	{
		this.sendKey(byFirstName, "First Name", firstName);
	}
	
	/**
	 * Set the Last Name input, with the given lastName parameter
	 * @param lastName Value to set the Last Name field
	 */
	public void setLastName(String lastName)
	{
		this.sendKey(byLastName, "Last Name", lastName);
		
	}
	
	/**
	 * Set the Password input, with the given password parameter, and click on 
	 * the Done button.
	 * @param Password Value to set the Password field
	 */
	public void setPassword(String password)
	{
		this.click(byCreatePassword, "");
		this.sendKey(byCreatePassword, "Password", password);
		this.Done();
	}
	
	/**
	 * Check if the error message throw by an invalid password 
	 * is displayed
	 * @return boolen -> True or False
	 */
	public boolean isErrorDisplayed()
	{
		this.hideKeyboard();
		boolean present = false;
		try
		{
			driver.findElement(By.name("Password Strength: WEAK"));
			return true;
		}
		catch(NoSuchElementException e)
		{}
		try
		{
			driver.findElement(By.name("Password Strength: MEDIUM"));
			return true;
		}
		catch(NoSuchElementException e)
		{}
		return present;
		
	}

	

}
