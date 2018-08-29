package awin.dao.exception;

public class ConnectionException extends BaseException {
	public ConnectionException()
	{
		
	}
	public ConnectionException(String msg)
	{
		super(msg);
	}
	
	public ConnectionException(String msg,Throwable e)
	{
		super(msg,e);
	}
}
