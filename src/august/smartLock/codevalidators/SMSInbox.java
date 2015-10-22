package august.smartLock.codevalidators;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;

public class SMSInbox {
protected AppiumDriver driver;

	By byMessageText = By.id("body_text_view");
	
	
	
	public SMSInbox(AppiumDriver d)
	{
		driver = d;	
	}
	
	public void readSMSFrom(String sender)
	{
		try
		{
			driver.findElement(By.name(sender)).click();
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The message was not found");
		}
	}
	
	public String getCodeFromMessage()
	{
		String messageContent = driver.findElement(byMessageText).getText();
		String[] words = messageContent.split(" ");
		int lenght = words.length;
		return (words[lenght-1]);
	}
	
	
	
}
