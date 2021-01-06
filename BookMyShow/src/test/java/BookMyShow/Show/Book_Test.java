package BookMyShow.Show;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.wrapperClass;


public class Book_Test extends BaseTest{
	
 HomePage objHomePage = new HomePage(this);

 @BeforeMethod
 public void inti()
 {
	this.intialSetUp();
 }
 @Test
 public void test() throws IOException
 {
	 objHomePage.handlePopUp();
	 objHomePage.setSearchCity();
	 objHomePage.clkMovies();
	 objHomePage.clkLanguage();
	 objHomePage.clkOnRandomMoview();
	 objHomePage.getActorsName();
	 objHomePage.clkbtnOnBookTickets();
	 objHomePage.selectDate();
	 objHomePage.varifyTitle();
	 objHomePage.selectShowTime();
	 objHomePage.clkOnBtnAccept();
	 objHomePage.SelectPrimeSeatNumber();
	 
 }
}
