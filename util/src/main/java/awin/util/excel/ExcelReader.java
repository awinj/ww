/**
 * 
 */
package awin.util.excel;

import awin.logger.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author wsw
 * @created 2017-11-28
 * 用于读取excel数据，可以处理xls，xlsx类型的excel。
 */
public class ExcelReader {

	Workbook workbook;
	InputStream is;
	public ExcelReader(String path) throws IOException 
	{   
		
		try {
			 is= new FileInputStream(path);
			if (path.endsWith("xls")) {    
	        	workbook = new HSSFWorkbook(is);
	        } else if (path.endsWith("xlsx")) {    
	        	workbook = new XSSFWorkbook(is);
	        }else{
	        	throw new IOException("仅支持xls或者xlsx格式的文件");
	        }
	        
		}
		 catch (IOException e) {
			if(is!=null)
				try {
					is.close();
				} catch (IOException e1) {
					throw e1;
				}
			throw e;
		}
	}
	
    
    public int getLastRowIndex(int sheetIndex)
    {
    	Sheet hssfSheet = workbook.getSheetAt(sheetIndex);
    	if(hssfSheet==null)
    		return -1;
    	else
    		return hssfSheet.getLastRowNum();
    }
   
    
    public Sheet getSheet()
    {
    	return getSheet(0);
    }
    
    public Sheet getSheet(int index)
    {
    	return  workbook.getSheetAt(index);
    }
    
    public String getDefaultSheetValue(int row,int col)
    {
    	return getValue(0,row,col);
    }
    
    public String getValue(int sheetIndex,int row,int col)
    {
    	if(getSheet()!=null&&row<=getSheet(sheetIndex).getLastRowNum())
    	{
    		if(getSheet(sheetIndex).getRow(row)!=null&&col<=getSheet(sheetIndex).getRow(row).getLastCellNum())
    		{
    			return getValue(getSheet().getRow(row).getCell((short)col));
    		}
    	}
    	return null;
    }
    
    public String getValue(int row,int col)
    {
    	if(getSheet()!=null&&row<=getSheet(0).getLastRowNum())
    	{
    		if(getSheet(0).getRow(row)!=null&&col<=getSheet(0).getRow(row).getLastCellNum())
    		{
    			return getValue(getSheet().getRow(row).getCell((short)col));
    		}
    	}
    	return null;
    }
    
    
    public int getBeginRow(int sheetIndex)
    {
    	if(getSheet(sheetIndex)==null)
    		return -1;
    	else
    		return getSheet(sheetIndex).getFirstRowNum();
    }
    
	public int getBeginColumn(int sheetIndex)
	{
		if(getSheet(sheetIndex)!=null&&getSheet(sheetIndex).getRow(getBeginRow(sheetIndex))!=null)
			return getSheet(sheetIndex).getRow(getBeginRow(sheetIndex)).getFirstCellNum();
		return -1;
	}
    
     @SuppressWarnings("static-access")
    private String getValue(Cell hssfCell) {
    	 if(hssfCell==null){
    		 return null;
    	 }else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
     }
     
     public void close()
     {
    	 if(is!=null)
			try {
				is.close();
			} catch (IOException e) {
				Logger.Error(e.getMessage(),e);
			}
     }
}