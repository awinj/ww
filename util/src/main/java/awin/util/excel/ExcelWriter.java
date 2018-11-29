package awin.util.excel;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;


import awin.logger.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
 * @author wsw
 * 用于写excel,可以处理xls，xlsx类型的excel。
 * 保存文件时，如果传如的路劲不存在，则会创建文件，如果创建文件失败，则会抛出异常
 */
public class ExcelWriter {

	Workbook workbook;
//	InputStream is;
	String excelpath;
	public ExcelWriter(String path) 
	{   
		if(path==null)
			path="新建表格.xlsx";
		if (!path.endsWith(".xlsx")
				&& !path.endsWith(".xls")) {
			path += ".xlsx";
		}
		if (path.endsWith("xls")) {    
        	workbook = new HSSFWorkbook();    
        } else if (path.endsWith("xlsx")) {    
        	workbook = new XSSFWorkbook();    
        }
		excelpath=path;
	}
	
	public void setValue(String sheetname,int row,int col,Object obj)
    {
		
		setValue(getCell(sheetname,row,col),obj);
    }
	
	private Row getRow(String sheetname, int row)
	{
		Row erow=getSheet(sheetname).getRow(row);
		if(erow==null)
			erow=getSheet(sheetname).createRow(row);
		return erow;
	}
	private Cell getCell(String sheetname,int row,int col)
	{
		Cell cell=getRow(sheetname,row).getCell(col);
		if(cell==null)
			cell=getRow(sheetname,row).createCell(col);
		return cell;
	}
    
    public void setValue(int row,int col,Object value)
    {
    	setValue("sheet0",row,col,value);
    }
    
    @SuppressWarnings("static-access")
    private void setValue(Cell cell,Object value) {
    	if(value==null||cell==null)
    	{
    		return ;
    	}
    	cell.setCellValue(value.toString());
     }
    public Sheet getSheet()
    {
    	return getSheet("sheet0");
    }
    public Sheet getSheet(String sheetname)
    {
    	Sheet sheet=workbook.getSheet(sheetname);
    	if(sheet==null)
    		sheet=workbook.createSheet(sheetname);
    	return sheet;
    }
    
    public void save() throws IOException
    {
    	File exportFile = new File(excelpath);
		try {
            exportFile.createNewFile();
		} catch (IOException ex) {
            throw new RuntimeException("创建文件失败，请检查路径是否正确");
        }
    	try {
	    	FileOutputStream out = new FileOutputStream(excelpath);
	    	workbook.write(out);
			out.close();
		} catch (IOException e) {
			Logger.Error(e.getMessage(),e);
			throw e;
		}
    }
    
    
    
    
}
