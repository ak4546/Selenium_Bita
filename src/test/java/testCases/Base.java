package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Base 
{
	
	@BeforeTest
	@Parameters("browser")
	public static void launchApp(String browser)
	{
		new LoginPage().launchDemoaut(browser);
	}
	
	@AfterTest	
	public void close() throws Exception
	{
		new HomePage().logOut();
		new LoginPage().closeApp();
		/*EmailReport.email();*/
	}

}
