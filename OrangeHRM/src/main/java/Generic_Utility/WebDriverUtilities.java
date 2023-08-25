package Generic_Utility;

import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	public void clickingOnTheElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void sendingDataToTextfield(WebDriver driver,WebElement element,String data)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" +data+ "';", element);
	}
	public void mouseOverTheElement(WebDriver driver, WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void switchToWindow(WebDriver driver, String parentwindow,Set<String> allwindowid,String title)
	{
		allwindowid.remove(parentwindow);
		for (String id : allwindowid) {
			driver.switchTo().frame(id);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
			
		}
	}
	public void switchbacktomainwindow(WebDriver driver,String parentwindow)
	{
		driver.switchTo().window(parentwindow);
	}
	
	public void handlingDropdown(WebElement dropdown,String value)
	{
		Select select=new Select(dropdown);
		try {
			select.selectByValue(value);
		}
		catch (NoSuchElementException e) {
			select.selectByVisibleText(value);

		}
		catch (Exception e) {
			select.selectByIndex(Integer.valueOf((String)value));
			// TODO: handle exception
		}

	}
	public void handlingDropdown(WebElement dropdown,int value)
	{
		Select select=new Select(dropdown);
		select.selectByIndex(value);
	}
	public void switchingToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used for switch the driver control to i frame
	 * @param driver
	 * @param name
	 */
	public void switchingToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);

	}
	/**
	 * this method is used for switch the driver control to i frame
	 * @param driver
	 * @param element
	 */
	public void switchingToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used for switch the driver control to alert popup
	 * @param driver
	 * @return
	 */
	public Alert switchingToAlert(WebDriver driver)
	{

		return driver.switchTo().alert();
	}

}
