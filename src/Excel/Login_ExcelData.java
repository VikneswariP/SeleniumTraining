package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Login_ExcelData {
	public static WebDriver driver;
	public static String excelpath, browser, URL;
	public static XSSFWorkbook workbook;
		
	public static void loadconfig() throws IOException {
		
		excelpath = "C:/Users/admin/Desktop/Framework/Sample.xlsx";
		workbook = new XSSFWorkbook(excelpath);
		/*FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();*/
		
		URL = workbook.getSheet("Config").getRow(1).getCell(1).getStringCellValue();
		browser = workbook.getSheet("Config").getRow(0).getCell(1).getStringCellValue();
	}
	
	public static void initdriver() throws IOException {
		
		
		switch(browser.toLowerCase().trim()) {
		case "chrome":
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/Framework/chromedriver.exe");
		driver = new ChromeDriver();
		break;
		
		case "firefox":
		System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Desktop/Framework/geckodriver.exe");
		driver = new FirefoxDriver();
		break;
		}
	}
	
	public static void correctLogin() throws InterruptedException, IOException {
		driver.get(URL);
		Row row = workbook.getSheetAt(0).getRow(1);
		//Row row1 = workbook.getSheetAt(0).getRow(1);
		driver.findElement(By.id("username")).sendKeys(row.getCell(0).getStringCellValue());
		driver.findElement(By.id("password")).sendKeys(row.getCell(1).getStringCellValue());
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		//String Cexcelpath = "C:/Users/admin/Desktop/Framework/Sample.xlsx";
		/*FileInputStream fis = new FileInputStream(Cexcelpath);
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
		
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(Cexcelpath);
		workbook1.write(fos);*/
		
		if(driver.findElement(By.cssSelector("img.logo")).isDisplayed()) {
			System.out.println("Successfully Logged In");
			row.createCell(3).setCellValue("PASS");
		} else {
			System.out.println("Not Logged In");
			row.createCell(3).setCellValue("FAIL");
		}
	}
	/*public static void main(String[] args) throws IOException, InterruptedException {
		
		//String 
		loadconfig();
		initdriver();
		correctLogin();
		
		for(Row row: workbook.getSheetAt(0)) {
			//for skipping the first row in excel
			
			if(row==workbook.getSheetAt(0).getRow(0))
			continue;
			//driver.get("http://www.adactin.com/HotelApp/");
			
			Thread.sleep(3000);

							
		}
		
		driver.close();
		workbook.close();	
	}*/
	
	
}