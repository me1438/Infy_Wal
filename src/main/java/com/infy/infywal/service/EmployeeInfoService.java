package com.infy.infywal.service;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.infy.infywal.util.Constants;

@Component
public class EmployeeInfoService {
	
	public void getEmpinfo() {
		 // Creating a Workbook from an Excel file (.xls or .xlsx)
        
		try {
			System.out.println(1);
			Workbook workbook= WorkbookFactory.create(new File(Constants.FILE_PATH));
			System.out.println(2);

	        // Retrieving the number of sheets in the Workbook
	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        
	        for(Sheet sheet: workbook) {
	        	int rowNbr = 1;
	        	int maxRows = sheet.getLastRowNum();
	        	while(rowNbr<=maxRows) {
	        		getRowDetails(rowNbr,sheet);
	        		rowNbr++;
	        	}
	        }
	        
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getRowDetails(int rowNbr,Sheet sheet) {
		DataFormatter dataFormatter = new DataFormatter();
		
			Row  row=sheet.getRow(rowNbr);
			for(Cell cell:row) {
				System.out.println(dataFormatter.formatCellValue(cell).toString());
			}
	}

}
