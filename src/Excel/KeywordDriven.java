package Excel;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordDriven extends Login_ExcelData {
	
	//We have written BY object down so we can also use by for function arguments
	//E.g., public void sendText(By by, String parameter) {
	
	public static void getParameter(String parameter, int rowNo ) {
		if(parameter.startsWith("<")) {
			
		}
		
	}
	
	public void performanceAction(String locator, String locatorValue, String keyword, String parameter) {
		switch(keyword) {
		
		//Since we wrote BY class in KeywordDriven we can also write the function as below
		//keywordObject.sendText(getByObject(locator, locatorValue), parameter);
		case "sendText":
			sendText(locator, locatorValue, parameter);
			break;
			
		case "click":
		click(locator, locatorValue);
		break;
		
		case "VerifyText":
			VerifyText(locator, locatorValue, parameter);
			break;
		
		case "listSelect":
			listSelect(getByObject(locator, locatorValue), parameter);
			break;	
			
		}

	}
	
	public void sendText(String locator, String locatorValue, String parameter) {
		WebElement element = driver.findElement(By.id(locatorValue));
		element.sendKeys(parameter);
	}
	
	public void click(String locator, String locatorValue) {
		WebElement element = driver.findElement(By.id(locatorValue));
		element.click();
	}

	public void VerifyText(String locator, String locatorValue, String parameter) {
		
		WebElement element = driver.findElement(By.xpath(locatorValue));
		if(element.isDisplayed()) {
			System.out.println("Successfully Logged In");
		}
		else {
			System.out.println("Not Logged In");
		}
		
	}
	
	/*public void select(String locator, String locatorValue, String parameter) {
		WebElement element = driver.findElement(By.id(locatorValue));
		element.sendKeys(parameter);
	}*/
	
	public void listSelect(By by, String parameter) {
		new Select(driver.findElement(by)).selectByValue(parameter);
	}
	
	public By getByObject(String locator, String locatorValue) {
		By by = null;
		
		switch(locator) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		}
	return by;
	}
}