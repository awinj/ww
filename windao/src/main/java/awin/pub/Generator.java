package awin.pub;

import awin.util.date.DateUtil;

/**
 * Created by aWin on 2018-11-12.
 */
public class Generator {
    private static int seed=1001;
    public static String genUniqueVal()
    {
        seed++;
        return "DF"+DateUtil.getCurrentTime2()+seed;
    }
}
