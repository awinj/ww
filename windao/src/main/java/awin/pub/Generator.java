package awin.pub;


import awin.util.date.DateUtil;

/**
 * Created by aWin on 2018-11-12.
 */
public class Generator {
    private static int seed=1001;
    private static String datetime="";
    private static final String prefix="ww";


    public static String genUniqueVal()
    {
        if(datetime.equals(DateUtil.getCurrentTime2()))
        {
            seed++;
        }
        else
        {
            datetime=DateUtil.getCurrentTime2();
            seed=1001;
        }
        return prefix+datetime+seed;
    }
}
