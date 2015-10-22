package august.smartLock.screens.registration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/**
 * 
 * @author MakingSense QA Team
 * 
 * The UploadProfilePhotoScreen class will receives the 
 * profile photo chooses for teh user 
 */
public class UploadProfilePhotoScreen extends ScreenObject{
	/*
	 * By locator to find the Upload photo button 
	 */
	By byUploadPhoto = By.id("signup_flow_user_picture_button");
	
	/*
	 * By locator to find the text
	 */
	By byText = By.id("signup_flow_upload_photo_text");
	
	/**
	 * By locator to find the Choose Picture option
	 */
	By byChoosePicture = By.name("Choose Picture");
	
	/**
	 * By locator to find the Continue button
	 */
	By byContinueButton = By.id("signup_flow_why_text");
	
	/**
	 * Class constructor.
	 * @param d - AppiumDriver
	 */
	public UploadProfilePhotoScreen(AppiumDriver d)
	{
		super(d);
	}
	
	/**
	 * Click on the Upload button
	 */
	public void clickOnUploadPhoto(){

		this.click(byUploadPhoto, "Upload Photo");
	}
	
	/**
	 * Go to the Photo option in order to select a profile photo
	 * @param sourceName Name of the option that the user
	 * chooses for upload a profile photo. Photo/Gallery
	 */
	public void goToPhotoSource(String sourceName)
	{
		choosePictureOption();
		choosePhotosSource(sourceName);
	}
	
	/*
	 *  Click on the Choose Picture option instead of Take Picture
	 */
	public void choosePictureOption()
	{
		this.click(byChoosePicture, "Choose Picture");
	}
	
	/*
	 * Select the photo in the given position
	 * @param i Position of the photo to chose
	 */
	public void choosePhotoByPosition(int i)
	{
		try{
			System.out.println("Selecting the first photo...");
			List<WebElement> photos = driver.findElements(By.xpath("//android.widget.ListView/descendant::android.widget.LinearLayout"));
			photos.get(i).click();
		}
		catch (IndexOutOfBoundsException e){
			System.out.println("The required photo was not found. See error: " + e.getMessage());
		}
	}
	
	/**
	 * Click on the Continue button
	 */
	public void clickOnContinue()
	{
		this.click(byContinueButton, "Continue");
	}
		
	/**
	 * Select the photo's source
	 * @param sourceName Name of the option that the user
	 * chooses for upload a profile photo. Photo/Gallery
	 */
	private void choosePhotosSource(String sourceName)
	{
		try{
			System.out.println("Selecting the " + sourceName + " as option...");
			List<WebElement> options = driver.findElements(By.xpath("//android.widget.GridView/descendant::android.widget.LinearLayout"));
			for(WebElement e : options)
			{
				WebElement textElement = e.findElement(By.id("text1"));
				if (textElement.getText().compareTo(sourceName) == 0)
				{			
					e.click();
					break;
				}
					
			}
		}
		catch (NoSuchElementException e){
			System.out.println("The " + sourceName + " source option was not found. See error: " + e.getMessage());
			
		}
		
	}
	
	public boolean isUploadProfilePhotoScreen()
	{			
		return ( this.isDisplayed(byUploadPhoto)&& this.isDisplayed(byText) );
	}	
}
