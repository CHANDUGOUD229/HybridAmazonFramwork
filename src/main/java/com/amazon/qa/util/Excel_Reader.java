package com.amazon.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public   XSSFRow row;
	public XSSFCell cell;
	public  String path="";
    public FileInputStream fi;
	public FileOutputStream fo;

	public Excel_Reader(String path) throws Exception  {
		fi= new FileInputStream(path);
		wb=new XSSFWorkbook(fi);

	}
	public int rowcount(String sheet ) {
		int row= wb.getSheet(sheet).getLastRowNum();
		return row;
	}
	public int colcount(String sheet,int row ) {
		int col= wb.getSheet(sheet).getRow(row).getLastCellNum();
		return col;
	}
	public String getdata(String sheetname, int rowname,int col )  throws Exception{
		sheet= wb.getSheet(sheetname);
		row=sheet.getRow(rowname);
		cell=row.getCell(col);
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	public void setdata(String sheetname, int rowname,int colnum ,String data)  throws Exception{
		sheet= wb.getSheet(sheetname);
		row=sheet.getRow(rowname);
		cell=row.createCell(colnum);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

}
	}
