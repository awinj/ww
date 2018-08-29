package awin.logger;

/**
 * Created by aWin on 2018-05-08.
 */
public class Logger {
    private static AbstractLogger logger;
    static {
        logger=AbstractLogger.getInstance(FileLogger.class);
    }


    public static void Error(String msg,Exception e)
    {
        logger.error(msg,e);
    }
    public static void Error(String msg)
    {
        logger.error(msg);
    }

    public static void Info(String msg,Exception e)
    {
        logger.info(msg,e);
    }
    public static void Info(String msg)
    {
        logger.info(msg);
    }
    public static void Debug(String msg,Exception e)
    {
        logger.debug(msg,e);
    }
    public static void Debug(String msg)
    {
        logger.debug(msg);
    }

    public static void warn(String s) { logger.warn(s);}
}
