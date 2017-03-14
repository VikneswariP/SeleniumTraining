package Excel;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class Logout{

public static void main(String[] args) throws InterruptedException, IOException {

System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/Framework/chromedriver.exe");

WebDriver driver = new ChromeDriver();
//WebDriver driver = new FirefoxDriver();

String excelpath = "C:/Users/admin/Desktop/Framework/Sample.xlsx";
XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
for(Row row: workbook.getSheetAt(0)) {
	//for skipping the first row in excel
	
	if(row==workbook.getSheetAt(0).getRow(0))
	continue;
	driver.get("http://www.adactin.com/HotelApp/");
	driver.findElement(By.id("username")).sendKeys(row.getCell(0).getStringCellValue());
	driver.findElement(By.id("password")).sendKeys(row.getCell(1).getStringCellValue());
	driver.findElement(By.id("login")).click();
	Thread.sleep(3000);
}

driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/a[4]")).click();

Thread.sleep(3000);
workbook.close();
 if(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/table/tbody/tr/td/a")).isDisplayed()) {
	 System.out.println("Successfully Logged out");
 }
		 driver.close();
}
}