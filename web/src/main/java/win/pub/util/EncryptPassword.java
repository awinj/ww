package win.pub.util;

import awin.util.encrypt.MD5;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
public class EncryptPassword {

    //默认密码
    public static final String defaultPassword="d41d8cd98f00b204e9800998ecf8427e";

    public static String encrypt(String password)
    {
        return MD5.encrypt("ww"+password+"jj");
    }
}
