package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends Pojo{



	static wrapperClass objWrapper1;
	
	public void intialSetUp()
	{
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objWrapper = new wrapperClass(this);

	}
}
