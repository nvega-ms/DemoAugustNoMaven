package august.smartLock.screens.registration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The PhoneNumberScreen class will receives phone number
 */
public class PhoneNumberScreen extends ScreenObject{
	
	/**
	 * By locator to find the Contry dropdown 
	 */
	By byChooseCountry = By.id("signup_flow_phone_container_country_code_container");
	
	/**
	 * By locator to find the Phone number input 
	 */
	By byEnterPhoneNumber = By.id("signup_flow_phone_container_phone_entry");
	
	/**
	 * By locator to find the Continue button
	 */
	By byContinue = By.id("signup_flow_phone_collection_continue");
	
	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public PhoneNumberScreen(AppiumDriver d)
	{
		super(d);
	}
	
	/**
	 * Click on the Country dropdown 
	 */
	public void clickOnCountrySelector()
	{
		this.click(byChooseCountry, "+1");
	}
	
	/**
	 * Select the given country name
	 * @param countryName Name of the contry to select
	 */
	public void chooseCountryByName(String countryName)
	{
		this.click(By.name(countryName), "Country Name");
	}
	
	/**
	 * Set the phoneNumber in the Phone number field
	 * @param phoneNumber Phone number to set in the Phone Number field
	 */
	public void enterPhoneNumber(String phoneNumber)
	{
		this.sendKey(byEnterPhoneNumber, "Phone numer", phoneNumber);
	}
	
	/**
	 * Click on the Continue button
	 */
	public void clickOnContinue()
	{ 
		this.click(byContinue, "Continue");
	}
	
}
