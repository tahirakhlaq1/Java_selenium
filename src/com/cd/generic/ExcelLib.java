package com.cd.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

public static final String filePath="/home/tahir/Downloads/selenium/testdata/testdata.xlsx";
	
	public static String readExcelData(int rowNum, int cellNum)
	{
		String data="";
		try{
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filePath)));
		data=wb.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
		catch(EncryptedDocumentException e){
		}
		catch (InvalidFormatException e) {
		}
		catch(FileNotFoundException e){
		}
		catch(IOException e){
		}
		return data;
	}
	
//	@SuppressWarnings("deprecation")
//	public static void setExcelData(int rowNum, int cellNum, String data){
//		System.out.println(rowNum);
//		try{
//			Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filePath)));
//			Cell c=wb.getSheet("Sheet1").getRow(rowNum).createCell(cellNum);
//			//c.cell.getCellTypeEnum() == CellType.STRING
//			c.setCellType(Cell.CELL_TYPE_STRING);
//			FileOutputStream fos=new FileOutputStream(new File(filePath));
//			c.setCellValue(data);
//			wb.write(fos);
//		}
//		catch(EncryptedDocumentException e){
//		}
//		catch (InvalidFormatException e) {
//		}
//		catch(FileNotFoundException e){
//		}
//		catch(IOException e){
//		}
//		
//	}
	public static void setExcel1Data(int i, int j, String s) throws Exception{
		
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filePath)));
		
		Cell c=wb.getSheet("Sheet1").getRow(i).createCell(j);
		c.setCellType(CellType.STRING);
		c.setCellValue(s);
		
		FileOutputStream fos=new FileOutputStream(new File(filePath));
		wb.write(fos);
		
	}
}
