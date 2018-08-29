package awin.dao.sql.util;

import awin.dao.exception.SqlParaNullException;

public class SqlString {

	
	protected StringBuilder sql;
	
	//作为临时操纵作的变量，每次操作完都需要置空。
	protected StringBuilder temp;
	
	
	protected StringBuilder getSql()
	{
		if(sql==null)
		{
			sql=new StringBuilder();
		}
		return sql;
	}
	protected StringBuilder getEmptySql()
	{
		sql=new StringBuilder();
		return sql;
	}
	
	/**
	 * 用逗号拼接字符串
	 * @param selectPara
	 * @throws SqlParaNullException 
	 */
	protected String appendWithComma(Object[] selectPara) throws SqlParaNullException {
		StringBuilder temp=new StringBuilder();
		if(isNullOrEmpty(selectPara))
		{
			throw new SqlParaNullException();
		}
		for(int i=0;i<selectPara.length;i++)
		{
			temp.append(" "+selectPara[i]+", ");
		}
		temp.delete(temp.length()-2,temp.length());
		return temp.toString();
	}
	
	
	public String toString()
	{
		return sql.toString();
	}
	
	protected boolean isNullOrEmpty(String str)
	{
		return (str==null||str.trim().length()==0);				
	}
	protected boolean isNullOrEmpty(Object[] objs)
	{
		return (objs==null||objs.length==0);				
	}
}
