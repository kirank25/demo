package Generic;

import org.openqa.selenium.WebDriver;

public class Pojo {

	public static WebDriver driver ;
	
	 wrapperClass objWrapper;
	
	public WebDriver getDriver()
	{
		return driver;
    }
	public void setDriver(WebDriver driver)
	{
		this.driver= driver;
	}
	public wrapperClass getWrapper()
	 {
		 return objWrapper;
	 }
}
