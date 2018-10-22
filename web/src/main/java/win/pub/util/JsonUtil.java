package win.pub.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by aWin on 2018-10-22.
 */
public class JsonUtil {


    public static String beanToJson(Object obj) {

        return JSON.toJSONString(obj);
    }

    public static <T> T jsonToBean(String json,Class<T> c)
    {
        T obj = JSON.parseObject(json, c);
        return obj;
    }
}
