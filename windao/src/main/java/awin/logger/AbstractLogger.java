package awin.logger;

/**
 * Created by aWin on 2018-05-08.
 */
public abstract class AbstractLogger {

    private static AbstractLogger logger;
    protected AbstractLogger(){}

    public static AbstractLogger getInstance(Class type)
    {
        return null;
    }

    public abstract void error(String msg,Exception e);
    public abstract void error(String msg);

    public abstract void info(String msg,Exception e);
    public abstract void info(String msg);

    public abstract void debug(String msg,Exception e);
    public abstract void debug(String msg);


    public abstract void warn(String s);
}
