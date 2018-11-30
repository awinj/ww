package awin.dao;

import java.util.List;
import java.util.Map;

import awin.bean.SuperVO;
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
		return getPersistence().insert(vo);
	}

	/**
	 *
	 * @param vo 插入的数据
	 * @return	返回插入数据的主键
	 * @throws DAOException
	 */
	public String[] insert(SuperVO[] vo) throws DAOException {
		return getPersistence().insert(vo);
	}

	/**
	 *
	 * @param vo 更新的数据
	 * @return	返回受影响的行数
	 * @throws DAOException
	 */
	public int update(SuperVO vo) throws DAOException {
		return getPersistence().update(vo);
	}

	/**
	 * 根据主键删除数据
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int delete(SuperVO vo) throws DAOException {
		return getPersistence().delete(vo);
	}

	/**
	 * 批量根据主键删除数据
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int delete(SuperVO[] vo) throws DAOException {
		return getPersistence().delete(vo);
	}
	/**
	 *
	 * @param c 查询类型
	 * @param <T>  SuperVO
	 * @return 返回实体集合
	 * @throws DAOException
	 */
	public <T extends SuperVO> List<T> query(Class<T> c) throws  DAOException {

		return getResultSetUtil().toBeanList(c, getPersistence().query(c));
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

		return getResultSetUtil().toBeanList(c, getPersistence().query(sql));
	}

	public <T > List<T> query(Class<T> c, String sql, SQLParameter parameter) throws  DAOException {

		return getResultSetUtil().toBeanList(c, getPersistence().query(sql,parameter));
	}

	/**
	 *
	 * @param c 查询的类型
	 * @param whereSql where 子句
	 * @param <T>
	 * @return 实体集合
	 * @throws DAOException
	 */
	public <T extends SuperVO> List<T> queryByWhere(Class<T> c,String whereSql) throws  DAOException {

		return getResultSetUtil().toBeanList(c, getPersistence().queryByWhere(c,whereSql));
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
		return getResultSetUtil().toBeanList(c,getPersistence().queryByPager(c,con,index,pageSize));
	}


	/**
	 *  返回int 值
	 * @param sql sql语句
	 * @return
	 * @throws DAOException
	 */
	public Integer query(String sql) throws DAOException {
		return getResultSetUtil().firstToInt(getPersistence().query(sql));
	}

	/**
	 * 查询符合条件的数据的条数
	 * @param c 类型
	 * @param whereSql whereSql
	 * @param <T>
	 * @return
	 */
	public <T extends SuperVO> Integer queryCount(Class<T> c,Map<String,Object> con) throws DAOException {
        return getResultSetUtil().firstToInt(getPersistence().queryCount(c,con));
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
	private Persistence getPersistence()
	{
		if(persistence==null)
		{
			persistence=new Persistence();
		}
		return persistence;
	}
	
}
