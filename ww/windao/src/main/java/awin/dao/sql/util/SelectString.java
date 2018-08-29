package awin.dao.sql.util;

import awin.dao.exception.FromParaNullException;
import awin.dao.exception.SqlParaNullException;

public class SelectString extends SqlString{

	
	public SelectString select(String selectPara)
	{
		if(isNullOrEmpty(selectPara))
		{
			getEmptySql().append(" select * ");
		}
		else
		{
			getEmptySql().append(" select "+selectPara);
		}
		return this;
	}
	
	public SelectString select(String[] selectPara) 
	{
		String temp=null;
		try {
			temp=appendWithComma(selectPara);
		} catch (SqlParaNullException e) {
		}
		select(temp);
		return this;
	}
	
	
	public SelectString from(String fromPara) throws FromParaNullException
	{
		if(isNullOrEmpty(fromPara))
		{
			throw new FromParaNullException();
		}
		sql.append(" from "+fromPara+" ");
		return this;
	}
	
	public SelectString where(String wherePara)
	{
		if(isNullOrEmpty(wherePara))
		{
			return this;
		}
		sql.append(" where "+wherePara+" ");
		return this;
	}


	
}
