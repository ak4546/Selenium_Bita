package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	
	@DataProvider(name="Login")
	public static Object[][] loginData() throws IOException 
	{
		Object[][] arrayObject = Excelutils.getSheet(Constants.loginTestCaseSheet);
		return arrayObject;
	}
	
	@DataProvider(name="FlightFinder")
	public static Object[][] FlightFinder() throws IOException 
	{
		Object[][] arrayObject = Excelutils.getSheet(Constants.flightFinderTestCaseSheet);
		return arrayObject;
	}

}
