package BookMyShow.Show;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Generic.Pojo;

public class HomePage {

	
	Pojo objPojo;
	
	public HomePage(Pojo objPojo)
	{
		this.objPojo = objPojo;
	}
	//Locators:- 
	
	By inpSearchCity = By.xpath("//img[@class='sc-dvCyap crAZss']");
	By CanclePopUp = By.xpath("//div[@class='wzrk-button-container']//child::button[@class='No thanks']");
	By lnkMovies = By.xpath("//a[.='Movies']");
	By lnkLanguage = By.xpath("//div[@class='sc-jRhVzh belpfk']");
	By MovieSelect = By.xpath("//div[@class='style__WidgetContainerBody-ldyxjk-0 kdiZX']//child::a");
	By actorsname = By.xpath("//h4[text()='Cast']//ancestor::section//descendant::img");
	By btnBookTicket = By.xpath("//*[@id=\"page-cta-container\"]/button/span");
	
	//Handle PopUp
	public void handlePopUp()
	{
		objPojo.getWrapper().click(CanclePopUp);
		
	}
	
	//Search for city textBox
	public void setSearchCity()
	{
		 objPojo.getWrapper().randomSelect(inpSearchCity);
	}
	//click on movies link 
	public void clkMovies()
	{
		objPojo.getWrapper().click(lnkMovies);
	}
	//select language
	public void clkLanguage()
	{
		
		objPojo.getWrapper().randomSelect(lnkLanguage);
	}
	//select Random movie
	public void clkOnRandomMoview()
    {
		objPojo.getWrapper().randomSelect(MovieSelect);
	}
	// get Actors name 
	public void getActorsName()throws IOException
	{
		 List<WebElement> name = objPojo.getDriver().findElements(actorsname);
		int Length = name.size();
		
		 for (int i=0;i<Length;i++)
		 {
			System.out.println(name.get(i).getAttribute("alt"));
			 FileWriter fw = new FileWriter("./target/data.txt",true);
			 fw.write(name.get(i).getAttribute("alt")+"\n");
			 fw.close(); 
		 }	 
	}
	public void clkbtnOnBookTickets()
	{
		objPojo.getWrapper().click(btnBookTicket);
	}
	
}
