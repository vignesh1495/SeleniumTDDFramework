package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class InputTestData {

	
	DataFormatter formatter = new DataFormatter(); 
	public Logger logger = LogManager.getLogger(this.getClass()); 

	public HashMap<String,HashMap<String,String>> getTestData(String sheetname){
	try {
	
		// x
		String testDataGridPath ="C:\\Users\\DELL\\eclipse-workspace\\FrameSelenium\\Book1.xlsx";
		logger.info("Reading data for "+sheetname+" started");
		XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File(testDataGridPath)));
		XSSFSheet sheet=wb.getSheet(sheetname);
		HashMap<String,HashMap<String,String>> mapOfTestData =
				new HashMap<String,HashMap<String,String>>();
		ArrayList<String> lstOfHeaders =new ArrayList<String>();
		Iterator<Row> rowIterator = sheet.iterator();
		boolean firsRowTraversed=false;
		boolean flag=false;
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator= row.cellIterator();
			int i=0;
			HashMap<String,String> testDataRow = new HashMap<String,String>();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(!firsRowTraversed) {
					lstOfHeaders.add(cell.getStringCellValue());
				}else {
					/*
					if(cell.getColumnIndex()!=i) {
						for(int j=i ;j<cell.getColumnIndex();j++) {
							testDataRow.put(lstOfHeaders.get(j)," ");
							if(j==cell.getColumnIndex()-1) {
								i=j+1;
								break;
							}
						}
					}
					
					*/
					testDataRow.put(lstOfHeaders.get(i++),formatter.formatCellValue(cell));
				}
				System.out.println(cell.getColumnIndex());
			}
		
			System.out.println(i);
			if(firsRowTraversed) {
				if(testDataRow!=null)
					
					mapOfTestData.put(testDataRow.get("Test_Data_Id"),testDataRow);
				
			}
			firsRowTraversed=true;
		}
		return mapOfTestData;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}
	
}