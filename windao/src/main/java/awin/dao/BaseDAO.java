package awin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import awin.bean.IORM;
import awin.bean.SuperVO;
import awin.bean.util.BeanHelper;
import awin.dao.exception.DAOException;
import awin.dao.persistence.Persistence;
import awin.dao.persistence.ResultSetUtil;
import awin.dao.persistence.type.SQLParameter;

public class BaseDAO {

	Persistence persistence;
	ResultSetUtil resultSetUtil;

	/**
	 *
	 * @param vo 插入的数据
	 * @return	返回插入数据的主键
	 * @throws DAOException
	 */
	public String insert(SuperVO vo) throws DAOException {
		String pk= getPersistence().insert(vo);
		getPersistence().closeAll();
		return pk;
	}

	/**
	 *
	 * @param vo 插入的数据
	 * @return	返回插入数据的主键
	 * @throws DAOException
	 */
	public String[] insert(SuperVO[] vo) throws DAOException {
		String[] pks =getPersistence().insert(vo);
		getPersistence().closeAll();
		return pks;
	}

	/**
	 *
	 * @param vo 更新的数据
	 * @return	返回受影响的行数
	 * @throws DAOException
	 */
	public int update(SuperVO vo) throws DAOException {
		int i= getPersistence().update(vo);
		getPersistence().closeAll();
		return i;
	}

	/**
	 * 根据主键删除数据
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int delete(SuperVO vo) throws DAOException {
		int ret= getPersistence().delete(vo);
		getPersistence().closeAll();
		return ret;
	}

	/**
	 * 批量根据主键删除数据
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int delete(SuperVO[] vo) throws DAOException {
		int ret= getPersistence().delete(vo);
		getPersistence().closeAll();
		return ret;
	}
	/**
	 *
	 * @param c 查询类型
	 * @param <T>  SuperVO
	 * @return 返回实体集合
	 * @throws DAOException
	 */
	public <T extends SuperVO> List<T> query(Class<T> c) throws  DAOException {

		ResultSet rs=getPersistence().query(c);
		List<T> ret= getResultSetUtil().toBeanList(c, rs);
		close(rs,getPersistence());
		return ret;
	}


	/**
	 *	必须为静态的sql,如果通过外界传入的参数进行拼接成的sql，会有sql注入的风险
	 * @param c 返回实体的类型
	 * @param sql sql语句
	 * @param <T>
	 * @return 返回实体集合
	 * @throws DAOException
	 */
	public <T > List<T> query(Class<T> c,String sql) throws  DAOException {
		ResultSet rs=getPersistence().query(sql);
		List<T> ret= getResultSetUtil().toBeanList(c, rs);
		close(rs,getPersistence());
		return ret;
	}

	public <T > List<T> query(Class<T> c, String sql, SQLParameter parameter) throws  DAOException {
		ResultSet rs=getPersistence().query(sql,parameter);
		List<T>ret= getResultSetUtil().toBeanList(c, rs);
		close(rs,getPersistence());
		return ret;
	}

	public  List query4List(String sql, SQLParameter parameter) throws  DAOException {
		ResultSet rs=getPersistence().query(sql,parameter);
		List ret= getResultSetUtil().toArrayList(rs);
		close(rs,getPersistence());
		return ret;
	}

	public  List query4List(String sql) throws  DAOException {
		ResultSet rs=getPersistence().query(sql);
		List ret= getResultSetUtil().toArrayList(rs);
		close(rs,getPersistence());
		return ret;
	}

	/**
	 *一般用于固定条件查询，例如 dr='N'
	 * @param c 查询的类型
	 * @param whereSql where 子句
	 * @param <T>
	 * @return 实体集合
	 * @throws DAOException
	 */
	public   <T extends SuperVO> List<T> queryByWhere(Class<T> c,String whereSql) throws  DAOException {

		ResultSet rs=getPersistence().queryByWhere(c,whereSql);
		List<T> ret= getResultSetUtil().toBeanList(c, rs);
		close(rs,getPersistence());
		return ret;
	}

	/**
	 *
	 * @param c 查询的类型
	 * @param whereSql where 子句
	 * @param <T>
	 * @return 实体集合
	 * @throws DAOException
	 */
	public <T extends SuperVO> List<T> queryByWhere(Class<T> c,String whereSql,SQLParameter parameter) throws  DAOException {

		ResultSet rs=getPersistence().queryByWhere(c,whereSql,parameter);
		List<T> ret= getResultSetUtil().toBeanList(c, rs);
		close(rs,getPersistence());
		return ret;
	}

	/**
	 *分页查询
	 * @param c 查询的数据类型
	 * @param con 查询条件
	 * @param index 页码从0开始
	 * @param pageSize 每页数据条数
	 * @param <T>
	 * @return 实体集合
	 * @throws DAOException
	 */
	public <T extends SuperVO> List<T> queryByPager(Class<T> c, Map<String,Object> con, Integer index, Integer pageSize) throws DAOException {
		ResultSet rs=getPersistence().queryByPager(c,con,index,pageSize);
		List<T> ret= getResultSetUtil().toBeanList(c, rs);
		close(rs,getPersistence());
		return ret;
	}


	/**
	 *  返回第一行第一列值
	 * @param sql sql语句
	 * @return
	 * @throws DAOException
	 */
	public Object query4First(String sql) throws DAOException {
		Object ret= getResultSetUtil().firstToObject(getPersistence().query(sql));
		getPersistence().closeAll();
		return ret;
	}

	/**
	 *  返回第一行第一列值
	 * @param sql sql语句
	 * @return
	 * @throws DAOException
	 */
	public Object query4First(String sql,SQLParameter parameter) throws DAOException {
		Object ret= getResultSetUtil().firstToObject(getPersistence().query(sql,parameter));
		getPersistence().closeAll();
		return ret;
	}

	public int update(String sql) throws DAOException {
		int ret= getPersistence().executeUpdate(sql);
		getPersistence().closeAll();
		return ret;
	}

	public int update(String sql,SQLParameter parameter) throws DAOException {
		int ret= getPersistence().executeUpdate(sql,parameter);
		getPersistence().closeAll();
		return ret;
	}

	public <T extends SuperVO> int deleteByWhere(Class<T> c,String where) throws DAOException {
		IORM vo= BeanHelper.createBean(c);
		String table=vo.getTableName();
		int ret= getPersistence().executeUpdate("delete from "+table+" where "+where);
		getPersistence().closeAll();
		return ret;
	}

	public <T extends SuperVO> int deleteByWhere(Class<T> c,String where,SQLParameter parameter) throws DAOException {
		IORM vo=BeanHelper.createBean(c);
		String table=vo.getTableName();
		int ret= getPersistence().executeUpdate("delete from "+table+" where "+where,parameter);
		getPersistence().closeAll();
		return ret;
	}

	/**
	 * 查询符合条件的数据的条数
	 * @param c 类型
	 * @param con 查询条件
	 * @param <T>
	 * @return
	 */
	public <T extends SuperVO> Integer queryCount(Class<T> c,Map<String,Object> con) throws DAOException {
        Integer ret= getResultSetUtil().firstToInt(getPersistence().queryCount(c,con));
		getPersistence().closeAll();
		return ret;
	}
	/**
	 *
	 * @return 返回ResultSet 处理工具
	 */
	private ResultSetUtil getResultSetUtil()
	{
		if(resultSetUtil==null)
		{
			resultSetUtil=new ResultSetUtil();
		}
		return resultSetUtil;
	}

	/**
	 *
	 * @return 返回持久层实例
	 */
	private Persistence getPersistence() throws DAOException {
		if(persistence==null)
		{
			persistence=new Persistence();
		}
		return persistence;
	}

	private void closeResultSet(ResultSet rs) throws DAOException {
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(),e);
		}
	}

	private void close(ResultSet rs,Persistence p) throws DAOException {
		closeResultSet(rs);
		p.closeAll();
	}
}
