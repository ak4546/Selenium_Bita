package pageObjects;

import java.util.Properties;

public class LoginPage extends GeneralPage
{
	Properties prop;
	
	public LoginPage()
	{
		prop = loadObjects();
	}
	
	
	public LoginPage launchDemoaut(String browser)
	{
		launchApp(browser);
		return this;
	}
	
	public LoginPage navigateUrl()
	{
		url("http://newtours.demoaut.com/mercurysignon.php");
		return this;
		
	}
	
	public LoginPage enterUserName(String userName)
	{
		enterName(prop.getProperty("Login.UserName.name"), userName);
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		enterPassword(prop.getProperty("Login.Password.name"), password);
		return this;
	}
	
	public HomePage clickLogin()
	{
		clickByName(prop.getProperty("Login.LoginButton.name"));
		return new HomePage();
	}
	
	public void closeApp()
	{
		closeBrowser();
	}
	
}
