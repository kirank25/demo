package BookMyShow.Show;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
	By SelectDate = By.xpath("//div[@class='date-numeric']");
	By ShowTime = By.xpath("//a[@class='showtime-pill']");
	By btnAccept = By.xpath("//a[@id='btnPopupAccept']");
	By SelectSeatPref = By.xpath("//li[contains(@id,'pop')]");
	By BtnSelectSeat = By.id("proceed-Qty");
	By clkOption3D = By.xpath("//div[@class='styles__BottomSheetContainer-xr4gt6-0 gSpSqW']//following::section[@class='styles__DimensionWrapper-sc-1efo077-2 kquseX']/child::div");
    By clkDate = By.xpath("//div[@class='slick-list draggable']//child::li");
    By popup = By.xpath("//div[@class='styles__BottomSheetContainer-xr4gt6-0 gSpSqW']");
//    By SeatNumberSelect = By.xpath("//td[@class='SRow1']/DIV");
    By SeatNumberSelect = By.xpath("//a[@class='_available']");
    By getNumberSeat = By.xpath("//div[@class='no-of-tickets']//span[@id='intQty']");
    By btnPayRs = By.xpath("(//a[@id='btmcntbook'])[1]");
    By ddTax = By.xpath("//*[@id=\"bksmile\"]/div[3]/div/div[1]/div[1]/ul/li[2]/div[1]/p/span[1]");
    By AmountTax = By.xpath("//*[@id=\"intHandlingFeeBreakdown\"]/ul/li[2]/span[2]");
    By mTicket = By.xpath("//*[@id=\"shmticket\"]/label");
    By btnProceed = By.xpath("//a[@id='prePay']");
    By 
	
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
	public void selectDate()
	{
		objPojo.getWrapper().randomSelect(SelectDate);
	}
	public void varifyTitle()
	{
		String Expected = objPojo.getDriver().getTitle();;
		String Actual = objPojo.getDriver().getTitle();
		Assert.assertEquals(Actual, Expected);
		System.out.println(Actual);
	}
	public void selectShowTime()
	{
		objPojo.getWrapper().randomSelect(ShowTime);
	}
	public void clkOnBtnAccept()
	{
		objPojo.getWrapper().click(btnAccept);
	}
//	public void SelectPrimeSeatNumber()
//	{
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		 ArrayList<Integer> arr1 = new ArrayList<Integer>();
//       objPojo.getWrapper().waitforvisibileelement(SelectSeatPref);
//		  List<WebElement> str = objPojo.getDriver().findElements(SelectSeatPref); 
//		System.out.println(str);
//		for (int i=0;i<str.size();i++)
//		{
//			int input = Integer.parseInt(str.get(i).getText());
//			arr.add(input);
//			System.out.println(arr.get(i));
//				
//		{
//			int input1=arr.get(i);
//			 int count=0;
//			 
//			 for (int j = 1; j <=input1; j++) 
//			 {
//			 if (input1%j==0) 
//			  {
//			 count++;
//			  }
//			 }
//			 if (count==2)
//			 {
//				 arr1.add(input1);
//				 System.out.println("Number is prime="+arr1);
//			 } 
//			 Random r= new Random();
//			int no= arr1.size();
//			System.out.println(no);
//			int rmumber = r.nextInt(no);
//			str.get(rmumber).click();
//
//		}
//		}
//	}
//		
	
//	public void SelectPrimeSeatNumber()
//	{
//		objPojo.getWrapper().waitforvisibileelement(SelectSeatPref);
//		objPojo.getWrapper().randomSelect(SelectSeatPref);
//		objPojo.getWrapper().click(BtnSelectSeat);
//		objPojo.getWrapper().randomSelect2(SeatNumberSelect);
//		  String s = objPojo.getDriver().findElement(getNumberSeat).getText();
//		  int num = Integer.parseInt(s);
//		  System.out.println(num);
//		  for(int i=0;i<=num-1;i++)
//		  {
//			  
//		  objPojo.getDriver().findElement(SeatNumberSelect).click();;
//		  }
//	}
		
	public void SelectPrimeSeatNumber()
	{
		
		objPojo.getWrapper().waitforvisibileelement(SelectSeatPref);

		int seatNo=objPojo.getWrapper().getPrimeNo();
		By locator = By.xpath("//li[@id='pop_"+seatNo+"']");
		objPojo.getWrapper().click(locator);
		
		objPojo.getWrapper().click(BtnSelectSeat);
		objPojo.getWrapper().randomSelect2(SeatNumberSelect);
		  String s = objPojo.getDriver().findElement(getNumberSeat).getText();
		  int num = Integer.parseInt(s);
		  System.out.println(num);
		  for(int i=0;i<=num-1;i++)
		  {			
			  objPojo.getDriver().findElement(SeatNumberSelect).click();
			  boolean flag = objPojo.getDriver().findElement(btnPayRs).isDisplayed();
			  while (flag==true)
			  {		
				  objPojo.getWrapper().click(btnPayRs);
			  }
		  
		  }
	}
	public void CalculateTaxAmount()
	{
		objPojo.getWrapper().click(btnPayRs);
		System.out.println(objPojo.getDriver().findElement(AmountTax).getText());
		objPojo.getWrapper().clickOnRadioButton(mTicket);
		objPojo.getWrapper().click(btnProceed);
		
	}
	
	}
	
	

