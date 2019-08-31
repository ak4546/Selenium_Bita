package pageObjects;

import java.io.IOException;
import java.util.Properties;

public class HomePage extends GeneralPage
{
	
	Properties prop;

	public HomePage()
	{
		prop = loadObjects();
	}
	
	public HomePage selectType(String type) throws Exception
	{			
		if(type.equalsIgnoreCase("OneWay"))
			clickRadioButton(prop.getProperty("Home.OneWay.xPath"));
		else if(type.equalsIgnoreCase("RoundTrip"))
			clickRadioButton(prop.getProperty("Home.RoundWay.xPath"));
		return this;
	}
	
	public HomePage selectNo_ofPassenger(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.passenger.name"), value);
		return this;
	}
	
	public HomePage DepartingFrom(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.DepartingFrom.name"), value);
		return this;
	}
	
	public HomePage On(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.On.name"), value);
		return this;
	}
	
	public HomePage Day(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.Day.name"), value);
		return this;
	}
	
	public HomePage ArrivingIn(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.ArrivingIn.name"), value);
		return this;
	}
	
	public HomePage ReturningMonth(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.ReturingMonth.name"), value);
		return this;
	}
	
	public HomePage ReturningDay(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.ReturingDay.name"), value);
		return this;
	}
	
	public HomePage ServiceClass(String value) throws Exception
	{	
		if(value.equalsIgnoreCase("EconomyClass"))
			clickRadioButton(prop.getProperty("Home.EconomyClass.xpath"));
		else if(value.equalsIgnoreCase("BusinessClass"))
			clickRadioButton(prop.getProperty("Home.BusinessClass.xpath"));
		else if(value.equalsIgnoreCase("FirstClass"))
			clickRadioButton(prop.getProperty("Home.FirstClass.xpath"));
		return this;
	}
	
	public HomePage Airline(String value) throws Exception
	{	
		selectByVisibleText(prop.getProperty("Home.Airline.name"), value);
		return this;
	}
	

	
	public LoginPage logOut()
	{
		clickByLinkText(prop.getProperty("Home.Logout.linktText"));
		return new LoginPage();
	}

	public HomePage verifyTitle(String expectedTitle) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		verifyTitle(driver.getTitle(), expectedTitle);
		return this;
	}


}
