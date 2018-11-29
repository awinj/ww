package awin.util.encrypt;

import awin.logger.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * md5加密，不可解密，常用于密码加密
 */
public class MD5 {
    public static final String KEY_MD5 = "ww";

    public static String encrypt(String inputStr) {
        System.out.println("加密前的数据:" + inputStr);
        String ret=null;
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            ret = new String(md.digest());
        } catch (Exception e) {
            Logger.Error(e.getMessage(),e);
        }
        System.out.println("MD5加密后:" + ret);
        return ret;
    }



}

