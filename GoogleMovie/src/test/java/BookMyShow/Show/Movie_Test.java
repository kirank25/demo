package BookMyShow.Show;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.wrapperClass;
import GoogleMovie.HomePage;


public class Movie_Test extends BaseTest{
	
 HomePage objHomePage = new HomePage(this);

 @BeforeMethod
 public void inti()
 {
	this.intialSetUp();
 }
 @Test
 public void test() throws IOException, InvalidFormatException
 {
	 System.out.println("1");
	 objHomePage.IntSearch();
 }
 
}
