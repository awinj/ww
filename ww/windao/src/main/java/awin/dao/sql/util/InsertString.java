package awin.dao.sql.util;

import awin.dao.exception.InsertParaNullException;
import awin.dao.exception.SqlParaNullException;

public class InsertString extends SqlString{

	public InsertString insert(String tableName) throws InsertParaNullException
	{
		if(isNullOrEmpty(tableName))
		{
			throw new InsertParaNullException();
		}
		else 
		{
			getEmptySql().append(" insert into "+tableName+" ");
		}
		return this;
	}
	
	private String values(String fieldPara,String valuePara) throws InsertParaNullException
	{
		if(isNullOrEmpty(fieldPara)||isNullOrEmpty(valuePara))
		{
			throw new InsertParaNullException();
		}
		else
		{
			getSql().append(" ( "+fieldPara +" ) values (" +valuePara+ " )");
		}
		return toString();
	}
//
//	public String values(String[] filedPara,Object[] valuePara) throws SqlParaNullException
//	{
//		String sql1=appendWithComma(filedPara);
//		String sql2=appendWithComma(valuePara);
//		return values(sql1,sql2);
//	}


	public String values(String[] filedPara) throws SqlParaNullException {
		String sql1=appendWithComma(filedPara);
		String[] values=new String[filedPara.length];
		for(int i=0;i<filedPara.length;i++)
		{
			values[i]="?";
		}
		String sql2=appendWithComma(values);
		return values(sql1,sql2);
	}
}
