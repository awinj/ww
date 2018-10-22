package awin.dao.exception;

public class DAOException extends BaseException {

	public DAOException()
	{
		
	}
	public DAOException(String msg)
	{
		super(msg);
	}
	
	public DAOException(String msg,Throwable e)
	{
		super(msg,e);
	}


}

