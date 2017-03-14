package Excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteOneCellValue {
	
	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook("C:/Users/admin/Desktop/Framework/Sample.xlsx");
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		XSSFRow row = sheet1.getRow(0);
		XSSFCell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		workbook.close();
	}
}