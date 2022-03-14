package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** This class is used for fetching the data from excel, and sending the test data */

public class TestDataUtils {

	/**
	 * Fetches the data from the excel as string, returns the fetched string value
	 * 
	 * @param row an integer of the row number in excel
	 * @param cell an integer of the cell number in excel
	 * @return the String data fetched from excel
	 * @exception EncryptedDocumentException  if the FileInputStream is used
	 * @exception IOException if the WorkbookFactory is used
	 */
	public String getExcelData(int row, int cell) throws EncryptedDocumentException, IOException  {
		FileInputStream file = new FileInputStream("./test-data/data.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet1");
		Row rowData = sh.getRow(row);
		Cell cellData = rowData.getCell(cell);
		String data = cellData.toString();
		return data;
	}

}
