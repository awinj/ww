package awin.util.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * base64 编码，可较简单的防止明文传输，可解码
 * 原理参照百度百科
 * 转前： s 1 3
 先转成ascii：对应 115 49 51
 2进制： 01110011 00110001 00110011
 6个一组（4组） 011100110011000100110011
 然后才有后面的 011100 110011 000100 110011
 然后计算机是8位8位的存数 6不够，自动就补两个高位0了
 所有有了 高位补0
 科学计算器输入 00011100 00110011 00000100 00110011
 得到 28 51 4 51
 查对下照表 c z E z
 */
public class BASE64 {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) {
        try {
            return new BASE64Decoder().decodeBuffer(key);
        } catch (IOException e) {
            throw new RuntimeException("解密失败：" + e.getMessage());
        }
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) {

        return new BASE64Encoder().encodeBuffer(key);
    }

    public static void main(String[] args) {

        String str = "12345678";

        String result1 = BASE64.encryptBASE64(str.getBytes());
        System.out.println("加密数据后：" + result1);

        byte result2[] = BASE64.decryptBASE64(result1);
        String str2 = new String(result2);
        System.out.println("解密数据后" + str2);


    }

}
