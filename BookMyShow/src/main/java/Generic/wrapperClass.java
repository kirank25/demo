package Generic;

import java.awt.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wrapperClass {
Pojo objPojo;

// constructor for wrapper class
public wrapperClass(Pojo objPojo)
{
	this.objPojo = objPojo;
}
//send text
public void setText(By locator , String name)
{
	objPojo.getDriver().findElement(locator).sendKeys(name);
}
//clear text
public void clear(By locator)
{
	objPojo.getDriver().findElement(locator).clear();
}
//click btn
public void clickOnRadioButton(By locator)
{
	objPojo.getDriver().findElement(locator).click();
}
//click method
public void click(By locator)
{
	objPojo.getDriver().findElement(locator).click();
}
//getting text
public String getText(By locator)
{
	WebElement res = objPojo.getDriver().findElement(locator);
	String res1 = res.getAttribute("value");
	return res1;
}
//waiting condition
public void waitforvisibileelement(By locator)
{
	WebDriverWait wait = new WebDriverWait(objPojo.getDriver(), 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
//mouse overing method
public void mouseOvering(By locator)
{
	Actions actions = new Actions(objPojo.getDriver());
	WebElement ElementOption = objPojo.getDriver().findElement(locator);
			actions.moveToElement(ElementOption).perform();
}
//Handle PopUp
public void HandlePopUp(By locator)
{
	Alert alt = objPojo.getDriver().switchTo().alert();
	alt.dismiss();
}

// Random number
public void randomSelect(By locator)
{
	java.util.List<WebElement> objrandomSelect = objPojo.getDriver().findElements(locator);
Random objrandom=new Random();
int size = objrandom.nextInt(objrandomSelect.size());
WebElement random = objrandomSelect.get(size);
String getSelectedName = random.getText();
System.out.println("You Have Selected= " +getSelectedName);
random.click();
}
}
