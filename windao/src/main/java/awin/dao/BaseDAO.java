package awin.dao;

import java.util.List;

import awin.bean.SuperVO;
import awin.dao.exception.DAOException;
import awin.dao.persistence.Persistence;
import awin.dao.persistence.ResultSetUtil;

public class BaseDAO {

	Persistence persistence;
	ResultSetUtil resultSetUtil;

	public String insert(SuperVO vo) throws DAOException {
		return getPersistence().insert(vo);
	}

	
	public int update(SuperVO vo) throws DAOException {
		return getPersistence().update(vo);
	}
	
	public <T extends SuperVO> List<T> query(Class<T> c) throws  DAOException {

		return getResultSetUtil().toBeanList(c, getPersistence().query(c));
	}

	public <T > List<T> query(Class<T> c,String sql) throws  DAOException {

		return getResultSetUtil().toBeanList(c, getPersistence().query(sql));
	}

	public <T extends SuperVO> List<T> queryByWhere(Class<T> c,String whereSql) throws  DAOException {

		return getResultSetUtil().toBeanList(c, getPersistence().queryByWhere(c,whereSql));
	}
	
	private ResultSetUtil getResultSetUtil()
	{
		if(resultSetUtil==null)
		{
			resultSetUtil=new ResultSetUtil();
		}
		return resultSetUtil;
	}
	private Persistence getPersistence()
	{
		if(persistence==null)
		{
			persistence=new Persistence();
		}
		return persistence;
	}
	
}
