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
		ds.setUserName("rpt");
		ds.setPassword("1");
		ds.setPort("1521");
		ds.setDataName("orcl");
		ds.setDataType(DBConsts.ORACLE);
		init(ds);
	}

	private static BasicConnection single;

	/**
	 * 单例模式，确保连接都是由single来管理。暂不考虑并发情况
	 * @return
	 */
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
		p.setProperty("maxActive", "30");//最大连接数量
		p.setProperty("minIdle","2");//最小空闲连接
		p.setProperty("maxIdle", "20");//最大空闲连接
		p.setProperty("initialSize","10");//初始化连接数
		p.setProperty("removeAbandoned","true");// 是否自动回收超时连接
		p.setProperty("removeAbandonedTimeout","300");//超时时间(以秒数为单位)
		p.setProperty("maxWait","200");//超时等待时间以毫秒为单位 1000等于60秒
		p.setProperty("timeBetweenEvictionRunsMillis","10000");//在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位，每10s运行一次回收
		p.setProperty("numTestsPerEvictionRun","4");//在每次空闲连接回收器线程(如果有)运行时检查的连接数量，每次检查4个连接是否需要回收
		p.setProperty("minEvictableIdleTimeMillis","10000");//连接在池中保持空闲而不被空闲连接回收器线程,以毫秒为单位
//		p.setProperty("testOnBorrow","true");//指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个.
//		p.setProperty("validationQuery","select 1 from dual");//检查连接是否可用的语句
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
