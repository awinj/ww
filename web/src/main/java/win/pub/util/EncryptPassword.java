package win.pub.util;

import awin.util.encrypt.MD5;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
public class EncryptPassword {

    public static String encrypt(String password)
    {
        return MD5.encrypt("ww"+password+"jj");
    }
}
