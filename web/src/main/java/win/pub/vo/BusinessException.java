package win.pub.vo;

import awin.dao.exception.DAOException;

/**
 * Created by aWin on 2018-09-07.
 */
public class BusinessException extends Exception {

    private String hint;
    private String errorCodeString = "";

    public BusinessException()
    {
    }

    public BusinessException(String msg)
    {
        super(msg);
        setErrorCodeString("-32000");
    }

    public BusinessException(String msg, String errorCode)
    {
        super(msg);
        setErrorCodeString(errorCode);
    }

    public String getHint()
    {
        return this.hint;
    }

    public void setHint(String newHint)
    {
        this.hint = newHint;
    }

    public BusinessException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BusinessException(Throwable cause)
    {
        super(cause);
    }

    public String getErrorCodeString() {
        return this.errorCodeString;
    }

    public void setErrorCodeString(String errorCode) {
        this.errorCodeString = errorCode;
    }
}
