/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsimulator;

/**
 *
 * @author I14746
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;




public class ExcelToJtable {

    String filePath  =  "";
    public ExcelToJtable(String file) {
        this.filePath = file;        
    }   
public List getSheetNames(){
    List list = new ArrayList();
        try {
            InputStream ExcelFileToRead = new FileInputStream(filePath);
            XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
            for(int p = 0; p < wb.getNumberOfSheets();p++){
                list.add(wb.getSheetName(p));
            }
        } catch (IOException ex) {
            Logger.getLogger(ExcelToJtable.class.getName()).log(Level.SEVERE, null, ex);
        }        
     return list;
}  

public int getSheetIndex(String Name){
    int index = 0;
    try {
            InputStream ExcelFileToRead = new FileInputStream(filePath);
            XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
            index = wb.getSheetIndex(Name);
        } catch (IOException ex) {
            Logger.getLogger(ExcelToJtable.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    return index;
}
public void readXLSFile() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream("C:/Test.xls");
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next();
		
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	
	}
	
	public void writeXLSFile() throws IOException {
		
		String excelFileName = "C:/Test.xls";//name of excel file

		String sheetName = "Sheet1";//name of sheet

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;

		//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			HSSFRow row = sheet.createRow(r);
	
			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				HSSFCell cell = row.createCell(c);
				
				cell.setCellValue("Cell "+r+" "+c);
			}
		}
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public List<String[]> readXLSXFile(int sheetnumber) throws IOException
	{
                List<String[]> list = new ArrayList<String[]>();                
		InputStream ExcelFileToRead = new FileInputStream(this.filePath);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(sheetnumber);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
                        String[] v = new String[6];                        
			Iterator cells = row.cellIterator();
			while(cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                int p = cell.getColumnIndex();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
//					System.out.print(cell.getStringCellValue()+" ");
//                                        v.add(p,cell.getStringCellValue()+" ");
                                        v[p] = cell.getStringCellValue()+" ";
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
//					System.out.print(cell.getNumericCellValue()+" ");
//                                        v.add(p,cell.getNumericCellValue()+" ");
                                    double temp = cell.getNumericCellValue();
                                    v[p] = Integer.toString((int)temp);
				}
				else
				{
//                                     v.add(p,"");
                                     v[p] = "";
					//U Can Handel Boolean, Formula, Errors
				}
			}
//			System.out.println();
                        list.add(v);
		}
                return list;
	
	}
	
	public void writeXLSXFile() throws IOException {
		
		String excelFileName = "C:/Test.xlsx";//name of excel file

		String sheetName = "Sheet1";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			XSSFRow row = sheet.createRow(r);

			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				XSSFCell cell = row.createCell(c);
	
				cell.setCellValue("Cell "+r+" "+c);
			}
		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}
