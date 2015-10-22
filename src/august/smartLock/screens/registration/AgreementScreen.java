package august.smartLock.screens.registration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author MakingSense QA Team
 * 
 * The AgreementScreen 
 */
public class AgreementScreen extends ScreenObject{
	/**
	 * By locator to find the Agree button
	 */
	By byAgreeButton = By.name("I Agree");
	
	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public AgreementScreen(AppiumDriver d)
	{
		super(d);
	}
	
	public void Agree()
	{
		this.click(byAgreeButton, "Agree");
	}

}
