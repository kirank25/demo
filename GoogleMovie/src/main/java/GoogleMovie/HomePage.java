package GoogleMovie;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.base.Throwables;
import com.google.common.collect.Table.Cell;

import Generic.Pojo;

public class HomePage {

	
	Pojo objPojo;
	
	public HomePage(Pojo objPojo)
	{
		this.objPojo = objPojo;
	}
	//Locators:- 
	
	By inpSearchTb= By.xpath("//input[@name='q']");
	By Lnkwikipidi= By.xpath("(//span[contains(text(),'Wikipedia')])[1]");

	
	By lnkLmdb = By.xpath("//th[text()='URL']/parent::tr/child::td/child::span/a");
	By inpSearchwiki = By.xpath("//input[@title='Search Wikipedia [alt-shift-f]']");
	By LnkIMDB = By.xpath("//div[@class='mw-search-result-heading']/a[@title='IMDb']");
	By TxtdirectorName = By.xpath("//th[text()='Directed by']/parent::tr/descendant::a");
	
//	By Lnkimdb = By.xpath("//a[@title='IMDb']//following-sibling::a//preceding-sibling::a//child::i");
	By Lnkimdb = By.xpath("//a[@title='IMDb']/preceding::a[contains(@href,'imdb')]");
	By GetDirectorName = By.xpath("//h4[.='Director:']//following-sibling::a");
	
	
	public void IntSearch () throws IOException, InvalidFormatException
	{
		//Exel data
		
			File src = new File("C:\\Users\\Verve Square\\Desktop\\MovieSheet.xlsx");
			XSSFWorkbook xsf = new XSSFWorkbook(src);
			XSSFSheet sheet= xsf.getSheet("Sheet1");
				Random Ron = new Random();
				int rowCount =Ron.nextInt(sheet.getLastRowNum());
			String cellData = sheet.getRow(rowCount).getCell(0).getStringCellValue();
			System.out.println("Movie Name :- "+cellData);
			objPojo.getWrapper().setText(inpSearchTb, cellData);
			Actions act = new Actions(objPojo.getDriver());
			act.sendKeys(Keys.ENTER).perform();
			objPojo.getWrapper().click(Lnkwikipidi);		
			String wikiDirectName = objPojo.getDriver().findElement(TxtdirectorName).getText();
			System.out.println("director name :- "+wikiDirectName);
			


//			WebElement element = objPojo.getDriver().findElement(Lnkimdb);
//			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
	        js.executeScript("window.scrollBy(0,10000)");
	        
			objPojo.getWrapper().click(Lnkimdb);
			String GetdirectName = objPojo.getDriver().findElement(GetDirectorName).getText();
			System.out.println("Get Director Name :- "+GetdirectName);
			
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Verve Square\\Desktop\\kk.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet2 = workbook.getSheet("Sheet1");
           XSSFRow row = sheet2.getRow(1);
           XSSFCell cell = row.createCell(1);
           cell.setCellValue(wikiDirectName);
           
           XSSFRow row2 = sheet2.getRow(2);
           XSSFCell cell2 = row2.createCell(2);
           cell2.setCellValue(GetdirectName);
			FileOutputStream fos1 = new FileOutputStream("C:\\Users\\Verve Square\\Desktop\\kk.xlsx");
			workbook.write(fos1);
			
			fos1.close();
			System.out.println("END OF WRITING DATA IN EXCEL");
			
			Assert.assertEquals(wikiDirectName, GetdirectName);
			
			}
		
	}
	
	
	

