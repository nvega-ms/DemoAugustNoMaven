package august.smartLock.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Class that get the rows from a given Excel file
 * 
 * @author MakingSense QA Team
 *
 */
public class ExcelUtils {

	/**
	 * Extract the information inside the Excel file
	 * @param FilePath - Path of the Excel file
	 * @param SheetName - Name of the sheet to get the information
	 * @return - Array containing the data extracted from the sheet
	 * @throws Exception
	 */
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		// Excel file
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile);
		
		//Sheet
	    XSSFSheet ws = wb.getSheet(SheetName);
	    
	    // Num of rows and columns
	    int rowNum = ws.getLastRowNum();
	    int colNum = ws.getRow(0).getLastCellNum();
	    
	    //Array to return
	    String [][] data = new String [rowNum] [colNum];
	    for(int i = 0; i <rowNum; i++){
	    	XSSFRow row = ws.getRow(i); //Getting the row
	        for (int j = 0; j < colNum; j++){
	        	XSSFCell cell = row.getCell(j); //Getting the "column"
	            String value = cell.toString();
	            data[i][j] = value;
	            
	        }
	    }
		return(data);

	}
}

