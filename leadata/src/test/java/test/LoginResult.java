package test;

public interface LoginResult
{

	public final static  int Success=10000;
	
	
	public final static int NoUser=10001;
	public final static String NoUserMsg="用户不存在";
	
	
	public final static  int Failure=10002;
	public final static String FailureMsg="登录失败，用户密码不匹配(AD域)";
	
	public final static  int ConnectError=10003;
	public final static String ConnectErrorMsg="ad域连接失败";
	
	public final static int UnKnowError=10004;
	public final static String UnKnowErrorMsg="AD域登录时发生未知错误";
	
	public final static int KeyError=1005;
	public final static String KeyErrorMsg="密钥不正确";
} 
