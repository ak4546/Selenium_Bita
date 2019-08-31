package dummy;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameters_Example 
{
	@Parameters({ "a", "b" })
	@Test
	  public void f(int a , int b) 
	  {
		 int c=a+b;
		 System.out.println(c);
	  }
  
	  @Parameters({ "a", "b" })
	  @Test
	  public void g(int a , int b) 
	  {
		 int d=a-b;
		 System.out.println(d);
	  }
}

