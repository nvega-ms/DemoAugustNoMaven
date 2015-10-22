package august.smartLock.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The LetMeInScreen class will receives the FirstName, LastName and Password of the user 
 */
public class LetMeInScreen extends ScreenObject{
	
	By byLetMeIn = By.id("CreateSixthStepScreen.java");

	
	public LetMeInScreen(AppiumDriver d)
	{
		super(d);
	}
	
	
	public void clickOnLetMeIn()
	{
		try{
			driver.findElement(byLetMeIn).click();
		}
		catch (NoSuchElementException e){
			System.out.println("The 'Let me in' element was not found. See error: " + e.getMessage());
		}
	}
	
}
