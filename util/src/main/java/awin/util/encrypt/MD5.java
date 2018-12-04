package awin.util.encrypt;

import awin.logger.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * md5加密，不可解密，常用于密码加密
 */
public class MD5 {
    public static final String KEY_MD5 = "md5";

    public static String encrypt(String inputStr) {
        System.out.println("加密前的数据:" + inputStr);
        String ret=null;
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);

            byte[] tmp=md.digest();
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < tmp.length; i++) {
//                int val = ((int) tmp[i]) & 0xff;
//                if (val < 16)
//                    sb.append("0");
//                sb.append(Integer.toHexString(val));
//
//            }
//            return sb.toString();

            ret=ByteUtil.bytes2Hex(md.digest());
        } catch (Exception e) {
            Logger.Error(e.getMessage(),e);
        }
        System.out.println("MD5加密后:" + ret);
        return ret;
    }


    public static void main(String[] args)
    {
        String str=encrypt("ww123qwejj");
        System.out.print(str);
    }

}

