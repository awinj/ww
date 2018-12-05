package awin.dao.conn;

import java.sql.Connection;
import java.util.Properties;

import awin.dao.db.DataSource;
import awin.dao.db.util.DBConsts;
import awin.dao.exception.ConnectionException;
import awin.logger.Logger;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public  class BasicConnection {


	private BasicDataSource dataSource;

	private BasicConnection()  {
		DataSource ds=new DataSource();
		ds.setIpAddress("127.0.0.1");
//		ds.setIpAddress("192.168.0.105");
		ds.setUserName("ww");
		ds.setPassword("1");
		ds.setPort("1521");
		ds.setDataName("orcl");
		ds.setDataType(1);
		init(ds);
	}

	private static BasicConnection single;
	public static BasicConnection getInstance()
	{
		if(single==null)
			single= new BasicConnection();
		return single;
	}

	private BasicConnection(DataSource ds)  {
		init(ds);
	}



	private BasicConnection(String url, String userName, String password) throws Exception {
		DataSource ds=new DataSource();
		ds.setIpAddress(url);
		ds.setUserName(userName);
		ds.setPassword(password);
		ds.setPort("1521");
		ds.setDataName("orcl");
		ds.setDataType(DBConsts.ORACLE);
		init(ds);
	}

	private void init(DataSource ds)  {
		//// FIXME: 2018-12-06 连接数不够的bug
		Properties p = new Properties();
		//oracle
		if(ds.getDataType() == DBConsts.ORACLE){
			p.setProperty("url", "jdbc:oracle:thin:@"+ds.getIpAddress()+":"+ds.getPort()+":"+ds.getDataName());
			p.setProperty("driverClassName", DBConsts.JDBC_ORACLE);
		}
		else if(ds.getDataType()==DBConsts.MYSQL){   // mysql
			p.setProperty("driverClassName", DBConsts.JDBC_MYSQL);
			p.setProperty("url", "jdbc:mysql://"+ds.getIpAddress()+":"+ds.getPort()+"/"+ds.getDataName());
		}
		else if (ds.getDataType() == DBConsts.SQLSERVER){  // sqlserver
			p.setProperty("driverClassName", DBConsts.JDBC_SQLSERVER);
			p.setProperty("url", "jdbc:sqlserver://"+ds.getIpAddress()+":"+ds.getPort()+"; DatabaseName="+ds.getDataName());
		}
		p.setProperty("username", ds.getUserName());
		p.setProperty("password", ds.getPassword());
		p.setProperty("maxActive", "10");
		p.setProperty("maxIdle", "20");
		p.setProperty("maxWait", "100");
		try {
			dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
		}
		catch (Exception e)
		{
			Logger.Error("数据源连接失败",e);
		}

	}

	public Connection getConnection() throws ConnectionException
	{
		Connection conn;
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			throw new ConnectionException(e.getMessage(),e);
		}
		return conn;
	}
}
