package Oxhead_property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataClass2 {
	FileInputStream fs;
	XSSFWorkbook wb;
	 XSSFSheet sh;
	 String filepath;
	 
	public DataClass2(String filepath) throws FileNotFoundException {
		this.filepath=filepath;
		
	}
	public String data(String sheetname,int rownumber, int cellnumber) throws IOException {
		fs=new FileInputStream(filepath);
		 wb =new XSSFWorkbook(fs);
		 sh=wb.getSheet(sheetname);
		 String value=sh.getRow(rownumber).getCell(cellnumber).getStringCellValue();
		 System.out.println("rownumber  "+rownumber+"   cellnumber  "+cellnumber+" value    "+value);
		 return value;
	}

}
