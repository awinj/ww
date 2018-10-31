package awin.dao.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import awin.bean.IORM;
import awin.bean.util.BeanHelper;
import awin.dao.conn.BasicConnection;
import awin.dao.db.util.DBConsts;
import awin.dao.db.util.DBUtil;
import awin.dao.exception.*;
import awin.dao.persistence.type.SQLParameter;
import awin.dao.sql.util.*;
import awin.logger.Logger;

public  class Persistence {

	
	public BasicConnection getBasicConnection()
	{
		return new BasicConnection();
	}
	
	 public String insert(IORM vo) throws DAOException
	 {
		 try
		 {
             Map<String, Integer> type=getColmnTypes(vo.getTableName());
			 String[] columns=getValidNames(vo,type);
			 String sql= new InsertString().insert(vo.getTableName()).values(columns);
			 Object pk=vo.getAttrValue(vo.getPrimaryKey());
			 if(pk==null)
			 {
					//TODO  生成主键
                 pk="主键";
			 }
			 PreparedStatement stmt =getBasicConnection().getConnection().prepareStatement(sql);
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
	 
	 public int update(IORM vo) throws DAOException {
		 try {
			 String sql= new UpdateString().update(vo.getTableName()).set(vo.getAttrNames(),vo.getAttrValues()).
					 where(vo.getPrimaryKey()+"='"+vo.getAttrValue(vo.getPrimaryKey())+"'").toString();
			 Statement stmt =getBasicConnection().getConnection().createStatement();
			 return stmt.executeUpdate(sql);
		 } catch (Exception e) {
			 throw new DAOException(e.getMessage(),e);
		 }
	 }
	 
	 public int delete(IORM vo)throws DAOException
	 {
		 try {
			 String sql=new DeleteString().deleteFrom(vo.getTableName()).where(vo.getPrimaryKey()+"='"+vo.getAttrValue(vo.getPrimaryKey())+"'").toString();
			 Statement stmt =getBasicConnection().getConnection().createStatement();
			 return stmt.executeUpdate(sql);
		 } catch (Exception e) {
			 throw new DAOException(e.getMessage(),e);
		 }
	 }
	 
	 public ResultSet query(Class c) throws DAOException {
		 return queryByWhere(c,null);
	 }
	public ResultSet queryByPk(Class c,String pk) throws DAOException {
		IORM vo= BeanHelper.createBean(c);
		if(vo!=null)
		{
			try {
				String sql=new SelectString().select(vo.getAttrNames()).from(vo.getTableName()).where(vo.getPrimaryKey()+"='"+pk+"'").toString();
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

	public ResultSet query(String sql) throws DAOException
	 {
		 try {
			 Statement stmt =getBasicConnection().getConnection().createStatement();
			 return stmt.executeQuery(sql);
		 } catch (Exception e) {
			 throw new DAOException(e.getMessage(),e);
		 }
	 }


	 public ResultSet queryByWhere(Class c,String where)throws DAOException
	 {
         IORM vo=BeanHelper.createBean(c);
		 if(vo!=null)
		 {
			 try {
				 String sql=new SelectString().select(vo.getAttrNames()).from(vo.getTableName()).where(where).toString();
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
	 *
	 * @param c VO 类
	 * @param index 页码
	 * @param pageSize 每页条数
	 * @return
	 */
	 public ResultSet queryByPager(Class c,String where,Integer index,Integer pageSize) throws DAOException {
		if(index==null)
			index=0;
		 if(pageSize==null)
		 	pageSize=10;

		  IORM vo=BeanHelper.createBean(c);
		if(vo!=null)
		{
			try {
				String tmptable=new SelectString().select(vo.getAttrNames()).append(" ,rownum as rowno").from(vo.getTableName()).where(where).toString();
				String sql=new SelectString().select(vo.getAttrNames()).from("("+tmptable+") t").where("t.rowno >="+index*pageSize+" and t.rowno <" +(index+1)*pageSize).toString();
				return query(sql);
			} catch (FromParaNullException e) {
				throw new DAOException(e.getMessage(),e);
			}
		}
		else
		{
			throw new DAOException("暂不支持本类型:"+String.valueOf(c));
		}

	 }


	 public ResultSet queryCount(Class c,String where) throws DAOException {
         IORM vo=BeanHelper.createBean(c);
         if(vo!=null)
         {
             try {
                 String sql=new SelectString().select(" count(1) ").from(vo.getTableName()).where(where).toString();
                 return query(sql);
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
	 * @param vo vo
	 * @param types  <列，类型>
	 * @return 得到有效的列名称
	 */
	private String[] getValidNames(final IORM vo, Map types) {
		String names[] = vo.getAttrNames();
		List<String> nameList = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			if (types.get(names[i].toUpperCase()) != null
					&& !names[i].equalsIgnoreCase("ts")) {
				nameList.add(names[i]);
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
					}
				} catch (SQLException e) {
                    e.printStackTrace();
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
				dbmd = getBasicConnection().getConnection().getMetaData();

			} catch (Exception e) {
				Logger.Error("getMetaData 出错",e);
			}
		return dbmd;
	}

	public int getDBType() {
		return DBUtil.getDbType(getMetaData());
	}



	public String getSchema() {
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
			e.printStackTrace();
		}
		return strSche;
	}

	/**
	 * 得到参数列表
	 * @param vo vo
	 * @param names 合法列名
	 * @param types <列，类型>
	 * @return 得到参数列表
	 */
	private SQLParameter getSQLParam(IORM vo, String names[],
									 Map<String, Integer> types) {
		SQLParameter params = new SQLParameter();
		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase("ts"))
				continue;
			int type = types.get(names[i].toUpperCase());
			Object value = vo.getAttrValue(names[i]);
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
}
