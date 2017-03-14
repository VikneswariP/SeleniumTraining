package Excel;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Keys;




public class TestRunner extends Login_ExcelData {
	
	//private static final String LocatorValue = null;
	//private static final String Locator = null;
	private static KeywordDriven keywordObject = new KeywordDriven();

	public static void main(String[] args) throws IOException {
		
		loadconfig();
		initdriver();
		driver.get(URL);
		
		for (Row dataRow: workbook.getSheet("TestData")) {
			if(dataRow == workbook.getSheet("TestData").getRow(0)) 
				continue;
	
		
		for (Row row: workbook.getSheet("TestCase")) {
			if(row == workbook.getSheet("TestCase").getRow(0)) 
				continue;
			String locator = row.getCell(0).getStringCellValue();
			String locatorValue = row.getCell(1).getStringCellValue();
			String keyword = row.getCell(2).getStringCellValue();
			String parameter;
			
			if((row.getCell(3))!= null) {
				parameter = row.getCell(3).getStringCellValue();
				
							}
			else {
				parameter = "";
				
			}
			
			
			keywordObject.performanceAction(locator, locatorValue, keyword, parameter);
			
		}
		}
		//driver.close();
	}
	
	

}