package awin.dao.exception;

public class BeanReflectException extends BaseException {

	public BeanReflectException()
	{
		
	}
	public BeanReflectException(String msg)
	{
		super(msg);
	}
	
	public BeanReflectException(String msg,Throwable e)
	{
		super(msg,e);
	}
}
