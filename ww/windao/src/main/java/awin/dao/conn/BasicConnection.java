package awin.dao.conn;

import java.sql.Connection;
import java.util.Properties;

import awin.dao.db.DataSource;
import awin.dao.exception.ConnectionException;
import awin.logger.Logger;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public  class BasicConnection {


	BasicDataSource dataSource;

	public BasicConnection()  {
		DataSource ds=new DataSource();
		ds.setIpAddress("10.230.28.204");
		ds.setUserName("dbwlhr");
		ds.setPassword("dbwlhr");
		ds.setPort("1521");
		ds.setDataName("hrdb");
		ds.setDataType(1);
		init(ds);
	}

	public BasicConnection(DataSource ds)  {
		init(ds);
	}


	
	public BasicConnection(String url, String userName, String password) throws Exception {
		DataSource ds=new DataSource();
		ds.setIpAddress(url);
		ds.setUserName(userName);
		ds.setPassword(password);
		ds.setPort("1521");
		ds.setDataName("orcl");
		ds.setDataType(1);
		init(ds);
	}

	private void init(DataSource ds)  {
		Properties p = new Properties();
		if(ds.getDataType() == 1){
			p.setProperty("url", "jdbc:oracle:thin:@"+ds.getIpAddress()+":"+ds.getPort()+":"+ds.getDataName());
			p.setProperty("driverClassName", "oracle.jdbc.OracleDriver");
		}else if(ds.getDataType()==2){
			p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			p.setProperty("url", "jdbc:mysql://"+ds.getIpAddress()+":"+ds.getPort()+"/"+ds.getDataName());
		}else if (ds.getDataType() == 3){
			p.setProperty("driverClassName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			p.setProperty("url", "jdbc:sqlserver://"+ds.getIpAddress()+":"+ds.getPort()+"; DatabaseName="+ds.getDataName());
		}
		p.setProperty("username", ds.getUserName());
		p.setProperty("password", ds.getPassword());
		p.setProperty("maxActive", "100");
		p.setProperty("maxIdle", "20");
		p.setProperty("maxWait", "10000");
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
		Connection conn=null;
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			throw new ConnectionException(e.getMessage(),e);
		}
		return conn;
	}
}
