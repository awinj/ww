package awin.dao.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import awin.bean.IORM;
import awin.dao.conn.BasicConnection;
import awin.dao.db.util.DBConsts;
import awin.dao.db.util.DBUtil;
import awin.dao.exception.*;
import awin.dao.persistence.type.SQLParameter;
import awin.dao.sql.util.*;
import awin.logger.Logger;
import awin.pub.Generator;
import awin.util.reflect.BeanHelper;

public  class Persistence {


	private Connection con;

	private int timeout=100;

	public void setTimeout(int timeout)
	{
		this.timeout=timeout;
	}

	private PreparedStatement prepStatement = null;
	private PreparedStatement getPrepStatement(String sql) throws DAOException {
		if(prepStatement!=null)
			closeStmt(prepStatement);
		try {
			this.prepStatement = this.con.prepareStatement(sql);
			prepStatement.setQueryTimeout(timeout);
			return prepStatement;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(),e);
		}
	}

	private Statement statement = null;
	private Statement getStatement() throws DAOException {
		if(statement!=null)
			closeStmt(statement);
		try {
			this.statement = con.createStatement();
				statement.setQueryTimeout(timeout);
			return statement;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(),e);
		}
	}

	
	private BasicConnection getBasicConnection()
	{
		return  BasicConnection.getInstance();
	}

	public Persistence() throws DAOException {
		try {
			//一个Persistence，一个数据库连接
			con=BasicConnection.getInstance().getConnection();
		} catch (ConnectionException e) {
			Logger.Error(e.getMessage());
			throw new DAOException("数据库连接失败");
		}
	}

	/**
	 * 同一个Persistence，返回的连接也是同一个
	 * @return 同一个Persistence，返回的连接也是同一个
	 */
	public Connection getConnection()
	{
		return con;
	}



	/**
	 * 新增数据
	 * @param vo vo实例，不为空
	 * @return 返回主键
	 * @throws DAOException 异常
	 */
	 public String insert(IORM vo) throws DAOException
	{
		try
		{
			Map<String, Integer> type=getColmnTypes(vo.getTableName());
			String[] columns=getValidNames(vo,type);
			String sql= new InsertString().insert(vo.getTableName()).values(columns);
			Object pk=vo.getAttrValue(vo.getPrimaryKey());
			if(pk==null||pk.toString().length()<=0)
			{
				pk= Generator.genUniqueVal();
				vo.setAttrValue(vo.getPrimaryKey(),pk);
			}
			PreparedStatement stmt =getPrepStatement(sql);
			Logger.Debug("insertsql:"+sql);
			stmt.clearParameters();

			SQLParameter parameter = getSQLParam(vo, columns, type);
			DBUtil.setStatementParameter(stmt, parameter);//j将参数传入到语句中
			stmt.executeUpdate();

			return pk.toString();
		}
		catch(Exception e)
		{
			throw new DAOException(e.getMessage(),e);
		}
	}


	/**
	 * 批量新增
	 * @param vos 实例，不为空
	 * @return 返回主键
	 * @throws DAOException 异常
	 */
	public String[] insert(IORM[] vos) throws DAOException
	{
		try
		{
			Map<String, Integer> type=getColmnTypes(vos[0].getTableName());
			String[] columns=getValidNames(vos[0],type);
			String sql= new InsertString().insert(vos[0].getTableName()).values(columns);
			String[] retPks=new String[vos.length];
			for(int i=0;i<vos.length;i++)
			{
				Object pk=vos[i].getAttrValue(vos[i].getPrimaryKey());
				if(pk==null||pk.toString().length()<=0)
				{
					pk= Generator.genUniqueVal();
					vos[i].setAttrValue(vos[i].getPrimaryKey(),pk);
				}
				retPks[i]=(String) pk;
			}
			PreparedStatement stmt =getPrepStatement(sql);
			Logger.Debug("insertsql:"+sql);
			stmt.clearParameters();

			SQLParameter[] parameters=new SQLParameter[vos.length];
			for(int i=0;i<vos.length;i++)
			{
				SQLParameter parameter = getSQLParam(vos[i], columns, type);
				parameters[i]=parameter;
			}

			DBUtil.setStatementParameter(stmt, parameters);//j将参数传入到语句中
			stmt.executeBatch();

			return retPks;
		}
		catch(Exception e)
		{
			throw new DAOException(e.getMessage(),e);
		}
	}

	/**
	 * 更新数据
	 * @param vo vo实例，不为空
	 * @return 更新的行数
	 * @throws DAOException 异常
	 */
	 public int update(IORM vo) throws DAOException {
		 try {
             Map<String, Integer> type=getColmnTypes(vo.getTableName());
             String[] columns=getValidNames(vo,type);
			 String sql= new UpdateString().update(vo.getTableName()).set(columns).
					 where(vo.getPrimaryKey()+"='"+vo.getAttrValue(vo.getPrimaryKey())+"'").toString();

             PreparedStatement stmt =getPrepStatement(sql);
             Logger.Debug("updatesql:"+sql);
             stmt.clearParameters();
             SQLParameter parameter = getSQLParam(vo,columns , type);
             DBUtil.setStatementParameter(stmt, parameter);//j将参数传入到语句中
             return stmt.executeUpdate();
		 } catch (Exception e) {
			 throw new DAOException(e.getMessage(),e);
		 }
	 }

	/**
	 * 根据主键删除数据
	 * @param vo vo实例，不为空
	 * @return 删除的行数
	 * @throws DAOException 异常
	 */
	 public int delete(IORM vo)throws DAOException
	 {
		 try {
			 String sql=new DeleteString().deleteFrom(vo.getTableName()).where(vo.getPrimaryKey()+"=?").toString();
			 Logger.Debug("deletesql:"+sql);

			 PreparedStatement stmt=getPrepStatement(sql);
			 SQLParameter parameter=new SQLParameter();
			 parameter.addParam(vo.getAttrValue(vo.getPrimaryKey()));
			 DBUtil.setStatementParameter(stmt, parameter);//j将参数传入到语句中
			return stmt.executeUpdate();
		 } catch (Exception e) {
			 throw new DAOException(e.getMessage(),e);
		 }
	 }


	/**
	 * 执行更新或删除语句，一般用于固定语句，例如 delete from table where dr='Y'
	 * @param sql 语句
	 * @return 影响的行数
	 * @throws DAOException 异常
	 */
	 public int executeUpdate(String sql) throws DAOException {
		 try {
			 Statement stmt =getPrepStatement(sql);
			 return stmt.executeUpdate(sql);
		 } catch (Exception e) {
			Logger.Error(e.getMessage(),e);
			 throw new DAOException(e.getMessage(),e);
		 }
	 }

	/**
	 * 执行更新或删除语句
	 * @param sql 语句
	 * @param parameter 参数
	 * @return 影响的行数
	 * @throws DAOException 异常
	 */
	public int executeUpdate(String sql,SQLParameter parameter) throws DAOException {
		try {
			PreparedStatement stmt =getPrepStatement(sql);
			if(parameter!=null)
				DBUtil.setStatementParameter(stmt, parameter);//j将参数传入到语句中
			return stmt.executeUpdate();
		} catch (Exception e) {
			Logger.Error(e.getMessage(),e);
			throw new DAOException(e.getMessage(),e);
		}
	}

	/**
	 * 根据主键批量删除数据
	 * @param vos vo实例，不为空
	 * @return 删除的行数
	 * @throws DAOException 异常
	 */
	public int delete(IORM[] vos)throws DAOException
	{
		try {
			String sql=new DeleteString().deleteFrom(vos[0].getTableName()).where(vos[0].getPrimaryKey()+"=?").toString();
			Logger.Debug("deletesql:"+sql);
			PreparedStatement stmt=getPrepStatement(sql);
			SQLParameter[] parameters=new SQLParameter[vos.length];
			for(int i=0;i<vos.length;i++)
			{
				parameters[i].addParam(vos[i].getAttrValue(vos[i].getPrimaryKey()));
//				stmt.setString(1,(String)vos[i].getAttrValue(vos[i].getPrimaryKey()));
//				stmt.addBatch();
			}
			DBUtil.setStatementParameter(stmt, parameters);//j将参数传入到语句中
			return stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}
	}

	/**
	 * 查询c的所有数据
	 * @param c IORM的子类
	 * @return 结果集
	 * @throws DAOException 异常
	 */
	 public ResultSet query(Class c) throws DAOException {
		 return queryByWhere(c,null);
	 }

	/**
	 * 根据主键值查询数据
	 * @param c IORM的子类
	 * @param pk 主键值
	 * @return 数据集
	 * @throws DAOException 异常
	 */
	public ResultSet queryByPk(Class<? extends IORM> c,String pk) throws DAOException {
		IORM vo= BeanHelper.createBean(c);
		if(vo!=null)
		{
			try {
				String sql=new SelectString().select(vo.getAttrNames()).from(vo.getTableName()).where(vo.getPrimaryKey()+"='"+pk+"'").toString();
				Logger.Debug("queryByPk sql:"+sql);
				return query(sql);
			} catch (Exception e) {
				throw new DAOException(e.getMessage(),e);
			}
		}
		else
		{
			throw new DAOException("本暂不支持类型:"+String.valueOf(c));
		}
	}

	/**
	 * 必须为静态的sql,如果通过外界传入的参数进行拼接成的sql，会有sql注入的风险
	 * @param sql 静态的可执行sql查询语句。
	 * @return 结果集
	 * @throws DAOException 异常
	 */
	public ResultSet query(String sql) throws DAOException
	{
		try {
			Statement stmt =getStatement();
			Logger.Debug("query sql:"+sql);
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}
	}


	public ResultSet query(String sql,SQLParameter parameter) throws DAOException
	{
		try {
			PreparedStatement stmt =getPrepStatement(sql);
			Logger.Debug("query sql:"+sql);
			DBUtil.setStatementParameter(stmt, parameter);//j将参数传入到语句中
			return stmt.executeQuery();
		} catch (Exception e) {
			throw new DAOException(e.getMessage(),e);
		}
	}


	/**
	 * 一般用于固定条件查询，例如 dr='N'
	 * @param c IORM的子类
	 * @param where  固定的查询条件
	 * @return 结果集
	 * @throws DAOException 异常
	 */
	 public ResultSet queryByWhere(Class<? extends IORM> c,String where)throws DAOException
	 {
         IORM vo= BeanHelper.createBean(c);
		 if(vo!=null)
		 {
			 try {
				 String sql=new SelectString().select(vo.getAttrNames()).from(vo.getTableName()).where(where).toString();
				 Logger.Debug("queryByWhere sql:"+sql);
				 return query(sql);
			 } catch (Exception e) {
				 throw new DAOException(e.getMessage(),e);
			 }
		 }
		 else
		 {
			 throw new DAOException("暂不支持本类型:"+String.valueOf(c));
		 }
	 }

	/**
	 * 根据条件查询vo类对应的表数据
	 * @param c IORM的子类
	 * @param where 条件
	 * @param parameter 参数
	 * @return 结果集
	 * @throws DAOException 异常
	 */
    public ResultSet queryByWhere(Class<? extends IORM> c,String where,SQLParameter parameter)throws DAOException
    {
        IORM vo=BeanHelper.createBean(c);
        if(vo!=null)
        {
            try {
                String sql=new SelectString().select(vo.getAttrNames()).from(vo.getTableName()).where(where).toString();
                Logger.Debug("queryByWhere sql:"+sql);
                return query(sql,parameter);
            } catch (Exception e) {
                throw new DAOException(e.getMessage(),e);
            }
        }
        else
        {
            throw new DAOException("暂不支持本类型:"+String.valueOf(c));
        }
    }


	/**
	 * 慎重使用,有sql注入的风险
	 * @param c IORM的子类
	 * @param where 固定的条件，如果由变量拼接参数，请调用queryByWhere(Class c,String where,SQLParameter parameter) 方法
	 * @return 结果集
	 * @throws DAOException 异常
	 */
	 private int deleteByWhere(Class<? extends IORM> c,String where) throws DAOException {
		 IORM vo=BeanHelper.createBean(c);
		 String table=vo.getTableName();
		 return executeUpdate("delete from "+table+" where "+where);
	 }

	 public int deleteByWhere(Class<? extends IORM> c,String where,SQLParameter parameter) throws DAOException {
		 IORM vo=BeanHelper.createBean(c);
		 String table=vo.getTableName();
		 return executeUpdate("delete from "+table+" where "+where,parameter);
	 }

	/**
	 *
	 * @param c VO 类
	 * @param index 页码
	 * @param pageSize 每页条数
	 * @return 结果集
	 */
	 public ResultSet queryByPager(Class<? extends IORM> c,Map<String,Object> con,Integer index,Integer pageSize) throws DAOException {
		if(index==null)
			index=0;
		 if(pageSize==null)
		 	pageSize=10;


		 QueryConditon conditon=initWhereParaByCon(con);
		 StringBuilder where=conditon.getSqlWhere();
		 IORM vo=BeanHelper.createBean(c);
		if(vo!=null)
		{
			try {
				String tmptable=new SelectString().select(vo.getAttrNames()).append(" ,rownum as rowno").from(vo.getTableName()).where(where.toString()).toString();
				String sql=new SelectString().select(vo.getAttrNames()).from("("+tmptable+") t").where("t.rowno >"+index*pageSize+" and t.rowno <=" +(index+1)*pageSize).toString();
				Logger.Debug("queryByPager sql:"+sql);
				return query(sql,conditon.getSqlParameter());
			} catch (FromParaNullException e) {
				throw new DAOException(e.getMessage(),e);
			}
		}
		else
		{
			throw new DAOException("暂不支持本类型:"+String.valueOf(c));
		}

	 }

	/**
	 * 转为为   key1 like ? and key2 like ?
	 * val 添加到 parameter 变量中
	 * @param con key-val
	 */
	private QueryConditon initWhereParaByCon(Map<String, Object> con) {
		StringBuilder where=new StringBuilder("1=1 ");
		SQLParameter parameter=new SQLParameter();
		if(con!=null)
        {
            for(String key : con.keySet())
            {
                Object val=con.get(key);
                if(val!=null&&val.toString().trim().length()>0)
                {
                    where.append(" and ").append(key).append(" like ?");
                    parameter.addParam(val);
                }
            }
        }
		QueryConditon conditon=new QueryConditon();
		conditon.setSqlParameter(parameter);
		conditon.setSqlWhere(where);
        return conditon;
	}


	/**
	 * 根据条件查询数据库包含数据的数量
	 * @param c vo类名 IORM的子类
	 * @param con 条件map
	 * @return 结果集
	 * @throws DAOException 异常
	 */
	public ResultSet queryCount(Class<? extends IORM> c,Map<String,Object> con) throws DAOException {


		 QueryConditon conditon=initWhereParaByCon(con);
		StringBuilder where=conditon.getSqlWhere();
		IORM vo=BeanHelper.createBean(c);
         if(vo!=null)
         {
             try {
                 String sql=new SelectString().select(" count(1) ").from(vo.getTableName()).where(where.toString()).toString();
				 Logger.Debug("queryCount sql:"+sql);
                 return query(sql,conditon.getSqlParameter());
             } catch (FromParaNullException e) {
                 throw new DAOException(e.getMessage(),e);
             }
         }
         else
         {
             throw new DAOException("暂不支持本类型:"+String.valueOf(c));
         }

     }





	/**
	 * 得到有效的列名称
	 *根据vo的属性与数据库的列名交集为有效的列名。
	 * @param vo vo实例，不为空 vo
	 * @param types  <列，类型>
	 * @return 得到有效的列名称
	 */
	private String[] getValidNames(final IORM vo, Map types) {
		String names[] = vo.getAttrNames();
		List<String> nameList = new ArrayList<String>();
		for (String name : names) {
			if (types.get(name.toUpperCase()) != null
					&& !name.equalsIgnoreCase("ts")) {
				nameList.add(name);
			}
		}
		return  nameList.toArray(new String[] {});
	}



	private static Map<String,Map<String, Integer>> cache = new ConcurrentHashMap<String,Map<String, Integer>>();
	/**
	 * 得到列的类型
	 *
	 * @param table 表名
	 * @return 得到列的类型
	 */
	private Map<String, Integer> getColmnTypes(String table) {
		Map<String, Integer> result =  cache.get(table);
		if (result == null) {
			Map<String, Integer> typeMap = new HashMap<String, Integer>();
			ResultSet rsColumns = null;
			try {

				if (getDBType() == DBConsts.SQLSERVER)
					rsColumns = getMetaData().getColumns(null, null,
							table.toUpperCase(), "%");
				else if(getDBType() == DBConsts.POSTGRESQL) {
					rsColumns = getMetaData().getColumns(null, null,
							table.toLowerCase(), "%");
				} else {
					rsColumns = getMetaData().getColumns(null, getSchema(),
							table.toUpperCase(), "%");
				}
				while (rsColumns.next()) {
					String columnName = rsColumns.getString("COLUMN_NAME")
							.toUpperCase();
					int columnType = rsColumns.getShort("DATA_TYPE");
					typeMap.put(columnName, columnType);
				}
				cache.put(table, typeMap);
				result = typeMap;
			} catch (SQLException e) {
				Logger.Error("get table metadata error", e);
			} finally {
				try {
					if (rsColumns != null) {
						rsColumns.close();
						closeConnection(con);
					}
				} catch (SQLException e) {
                    Logger.Error(e.getMessage(),e);
				}
			}
		}
		return result;
	}

	private DatabaseMetaData dbmd;
	private DatabaseMetaData getMetaData()
	{
		if (dbmd == null)
			try {
				dbmd = con.getMetaData();

			} catch (Exception e) {
				Logger.Error("getMetaData 出错",e);
			}
		return dbmd;
	}

	private int getDBType() {
		return DBUtil.getDbType(getMetaData());
	}



	private String getSchema() {
		String strSche = null;
		try {
			String schema = getMetaData().getUserName();
			switch (getDBType()) {
				case DBConsts.SQLSERVER:
					strSche = "dbo";
					break;
				case DBConsts.ORACLE:
				case DBConsts.DB2: {
					if (schema == null || schema.length() == 0)
						throw new IllegalArgumentException("ORACLE数据库模式不允许为空");
					// ORACLE需将模式名大写
					strSche = schema.toUpperCase();
					break;
				}
			}
		} catch (Exception e) {
			Logger.Error(e.getMessage(),e);
		}
		return strSche;
	}

	/**
	 * 得到参数列表
	 * @param vo vo实例，不为空 vo
	 * @param names 合法列名
	 * @param types <列，类型>
	 * @return 得到参数列表
	 */
	private SQLParameter getSQLParam(IORM vo, String names[],
									 Map<String, Integer> types) {
		SQLParameter params = new SQLParameter();
		for (String name : names) {
			if (name.equalsIgnoreCase("ts"))
				continue;
			int type = types.get(name.toUpperCase());
			Object value = vo.getAttrValue(name);
			if (value == null) {
				params.addNullParam(type);
				continue;
			}
			if (type == Types.BLOB || type == Types.LONGVARBINARY
					|| type == Types.VARBINARY || type == Types.BINARY) {
				params.addBlobParam(value);
				continue;
			}
			if (type == Types.CLOB || type == Types.LONGVARCHAR) {
				params.addClobParam(String.valueOf(value));
				continue;
			}
			params.addParam(value);

		}
		return params;
	}


	public void closeAll() {
		closeStmt(statement);
		closeStmt(prepStatement);
		closeConnection(con);
	}

	private void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			Logger.Error(e.getMessage());
		}
	}
	private void closeStmt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			Logger.Error(e.getMessage());
		}
	}



	private class QueryConditon
	{
		SQLParameter sqlParameter;
		StringBuilder sqlWhere;

		public SQLParameter getSqlParameter() {
			return sqlParameter;
		}

		public void setSqlParameter(SQLParameter sqlParameter) {
			this.sqlParameter = sqlParameter;
		}

		public StringBuilder getSqlWhere() {
			return sqlWhere;
		}

		public void setSqlWhere(StringBuilder sqlWhere) {
			this.sqlWhere = sqlWhere;
		}
	}

}
