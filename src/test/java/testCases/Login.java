package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utility.DataProviders;
//import utility.SendEmail;

public class Login extends Base
{
	
	{
		 System.setProperty("atu.reporter.config", "atu.properties"); 
		
	}
	
	@Test(dataProvider = "Login", dataProviderClass=DataProviders.class, priority=2)
	public static void Login_TC01(String userName, String password, String expectedTitle) throws Exception
	{
		new LoginPage()
		.navigateUrl().enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.verifyTitle(expectedTitle);		
	}
	
	
	@Test(dataProvider = "FlightFinder", dataProviderClass=DataProviders.class)
	public static void FlightFinder(String userName, String password, String type, String passenger, String Departingfro, 
			String departOn, String departDay, String ArrivingIn, String ReturnMon, String returnDay, String ServiceClass, String airline ) throws Exception
	{
		new LoginPage()
		.navigateUrl()
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.selectType(type)
		.selectNo_ofPassenger(passenger)
		.DepartingFrom(Departingfro)
		.On(departOn)
		.Day(departDay)
		.ArrivingIn(ArrivingIn)
		.ReturningMonth(ReturnMon)
		.ReturningDay(returnDay)
		.ServiceClass(ServiceClass)
		.Airline(airline);
	}
	

}
