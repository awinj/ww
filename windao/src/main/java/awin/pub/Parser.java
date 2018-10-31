package awin.pub;

/**
 * Created by aWin on 2018-10-31.
 *
 * @Description: 基础类型转化
 */
public class Parser {
    public static Integer parseInt(Object obj)
    {
        return Integer.parseInt(obj.toString());
    }

    public static String toString(Object obj)
    {
        return obj.toString();
    }
}
