package august.smartLock.codevalidators;

import io.appium.java_client.AppiumDriver;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import august.smartLock.screens.registration.ScreenObject;

public class EmailInbox extends ScreenObject{
	
		
	public EmailInbox(AppiumDriver d)
	{
    	 super(d);
    }
	// August verification code
	public String getVerificationCode(){
		String name = "";
		
		getMessageBySubject("August verification code");
		try{
			List<WebElement> lines = driver.findElements(By.xpath("*/descendant::android.view.View"));
			/*int lenght = lines.size() - 1;
			String code = lines.get(lenght).getAttribute("name").replaceAll("\\D", "");
			return code;*/
			for(WebElement e : lines)
			{
				name = e.getAttribute("name");
				if (name.contains("Your August email verification code is"))
				{			
					String code = name.replaceAll("\\D", "");
					System.out.println("Code: " + code);
					return code;
				}
			}
			
		}
		
		catch(NoSuchElementException e)
		{
			return null;
		}	
		
		
		return null;
	}
	public void getMessageBySubject(String subject)
	{
		try{
			
			List<WebElement> options = driver.findElements(By.xpath("//android.widget.ListView/descendant::android.view.View"));
			for(WebElement e : options)
			{
				String name = e.getAttribute("name");
				if (name.contains(subject))
				{			
					e.click();
					break;
				}
			}
		}
		catch (NoSuchElementException e){
			System.out.println( e.getMessage());
		
		}
		
	}
	
/*
	 WebDriver driver;
	 
	 By bySignInButton = By.id("signIn");

	 By byToken = By.xpath("id(':jo')/x:p/x:a");
	 
     public EmailInbox(WebDriver d){
    	 driver = d;
     }

     public void Navigate()
	 {
	     driver.get("https://mail.google.com/");
	 }

	 public void Submit()
	 {
	    driver.findElement(bySignInButton).click();
	 }

	 public void SetUsername(String username)
	 {
	     driver.findElement(By.name("Email")).sendKeys(username);
	 }

	 public void SetPassword(String password)
	 {
	     driver.findElement(By.name("Passwd")).sendKeys(password);
	 }

	 public boolean openNewEmailByEmail(String email, String name)
	 {
	     try
	     {
	        for (int i = 0; i < 10; i++)
	        {
	            List<WebElement> emailCollection = driver.findElements(By.cssSelector("div.yW span.zF"));
	            for( WebElement item: emailCollection)
	            {
	                 if (item.getAttribute("email").equals(email) && item.getAttribute("name").equals(name))
	                    {
	                        driver.findElement(By.cssSelector("div.yW span.zF")).click();
	                        Wait(By.cssSelector("div.h7.ie.nH.oy8Mbf"));
	                        return true;
	                     }
	                 }
	                    driver.navigate().refresh();
	                    wait(1000);
	                }
	                return false;
	            }
	            catch (Exception ex)
	            {
	            	 return false;
	            }
	        }

	        public boolean OpenNewEmailBySubject(String subject)
	        {
	            try
	            {
	                for (int i = 0; i < 10; i++)
	                {
	                	List<WebElement> emailCollection = driver.findElements(By.cssSelector("div.y6 span b"));
	                    for (WebElement email : emailCollection)
	                    {
	                        if (email.getText().equals(subject))
	                        {
	                            email.click();
	                            Wait(By.cssSelector("div.h7.ie.nH.oy8Mbf"));
	                            return true;
	                        }
	                    }
	                    driver.navigate().refresh();
	                    wait(3000);
	                }
	                return false;
	            }
	            catch (Exception ex)
	            {
	          
	            }
	            return false;
	        }

	        public void Wait(By by)
	        {
	            try
	            {
	                WebDriverWait wait;
	                long timeout = 40000;
	                wait = new WebDriverWait(driver, timeout);
	                wait.until(new Predicate<WebDriver>() {
	                    public boolean apply(WebDriver d) {
	                        return d.findElement(by).isDisplayed();
	                    }
	                });
	            }
	            catch (TimeoutException ex)
	            {
	          
	            }
	        }

	        public void wait(int mills)
	        {
	            try {
					Thread.sleep(mills);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

	        public boolean deleteCurrentMail()
	        {
	            try
	            {
	                driver.findElement(By.xpath("//div[@id=':5']/div/div/div/div[2]/div[3]/div/div")).click();
	                wait(2000);
	            }
	            catch (Exception ex)
	            {
	         
	            }
	            return true;
	        }      
*/
	       	 
	}


