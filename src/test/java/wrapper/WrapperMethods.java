package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;


public class WrapperMethods 
{
public static RemoteWebDriver driver;

public static Logger log;
	
	@Parameters("browser")
	public static void launchApp(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("fireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Santhosh\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
	}
	
	public static void url(String Url)
	{
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void enterName(String locator, String value)
	{
		try
		{
		
		driver.findElement(By.name(locator)).clear();	
		driver.findElement(By.name(locator)).sendKeys(value);
		log = Logger.getLogger(WrapperMethods.class); 
		log.info("Type In Text field.");
		
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No Name field Locator present");
		}
	}
	
	public static void enterPassword(String locator, String value)
	{
		try
		{
		driver.findElement(By.name(locator)).clear();
		driver.findElement(By.name(locator)).sendKeys(value);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No Password field Locator present");
		}
	}
	
	public static void clickByName(String locator)
	{
		try
		{
		driver.findElement(By.name(locator)).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No login field Locator present");
		}
	}
	
	
	
	public static void clickByLinkText(String locator)
	{
		try
		{
		driver.findElement(By.linkText(locator)).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No logout Locator present");
		}
	}
	
	public static void closeBrowser()
	{
		driver.quit();
		
	}
	
	public Properties loadObjects()
	{
		Properties prop = new Properties();
		
		try
		{
			prop.load(new FileInputStream(new File("object.properties")));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("object file not found");
		}
		catch(IOException e)
		{
			System.out.println("object file not found");
		}
		
		return prop;
	}
	
	public static void clickRadioButton(String xpath)
	{
		try
		{
		driver.findElement(By.xpath(xpath)).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No radioButton xpath locator found");
		}
	}
	
	public static void selectByVisibleText(String name, String value) throws IOException
	{
		List<WebElement> dropdown = driver.findElements(By.name(name));
		
		for (WebElement listOfOptions : dropdown) 
		{
			
			if(listOfOptions.getText().contains(value))
			{
				Select drop = new Select(driver.findElement(By.name(name)));
				drop.selectByVisibleText(value);
			}
			else
			{
				System.out.println(value +" "+"not found in dropdown option: "+ name);
			}
		}	
	}
	
	public static void verifyTitle(String actualTitle, String expectedTitle) throws IOException
	{
		
			if(actualTitle.equals(expectedTitle))
			{
			}
			else
			{
			}
	}
	
	public static void verifyText(String text) throws IOException
	{
		if(driver.getPageSource().contains(text))
		{
		}
		else
		{
			System.out.println(text +" "+"not verified");
		}
		
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(""));
	}

}
