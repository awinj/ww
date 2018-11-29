package awin.util.encrypt;

import awin.logger.Logger;

import java.security.MessageDigest;

public class SHA {
    public static final String KEY_SHA = "SHA";

    public static String getResult(String inputStr) {
        String ret = null;
        System.out.println("加密前的数据:" + inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            ret = new String(messageDigest.digest());
            System.out.println("SHA加密后:" + ret);
        } catch (Exception e) {
            Logger.Error(e.getMessage(),e);
        }
        return ret;
    }

    public static void main(String args[]) {
        try {
            String inputStr = "简单加密";
            getResult(inputStr);
        } catch (Exception e) {
            Logger.Error(e.getMessage(),e);
        }

    }

}

