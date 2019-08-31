package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Excelutils 
{
	
public static String[][] getSheet(String dataSheetName) throws IOException{
		
		String[][] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\TestData\\Sample.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheet(dataSheetName);	
			
			// get the number of rows
			int rowCount = sheet.getLastRowNum();
			
			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					HSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							HSSFCell cell;
							String cellValue = "";
							try
							{
								cell=row.getCell(j);
								int type = cell.getCellType();
								if(type==Cell.CELL_TYPE_NUMERIC)
								{
									cell.setCellType(Cell.CELL_TYPE_STRING);
								}
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){
								
							}
							
							data[i-1][j]  = cellValue; 
						} catch (Exception e) {
							
							e.printStackTrace();
						}				
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			fis.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return data;
		
	}

}
