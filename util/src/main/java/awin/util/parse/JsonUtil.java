package awin.util.parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JsonUtil {

    public static String beanToJson(Object obj) {
//        ObjectMapper mapper = new ObjectMapper();
//        StringWriter writer = new StringWriter();
//        JsonGenerator gen=null;
//        String parse="";
//        try {
//            gen = new JsonFactory().createJsonGenerator(writer);
//            mapper.writeValue(gen, obj);
//            parse = writer.toString();
//            gen.close();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return parse;


        ObjectMapper objectMapper = new ObjectMapper();

        String json ;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage() + "/n转化成实体失败");
        }
        return json;
    }


    public static <T> T jsonToBean(String json, Class<T> c) {
        ObjectMapper objectMapper = new ObjectMapper();
        T obj;
        try {
            obj = objectMapper.readValue(json, c);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage() + "/n转化成实体失败");
        }
        return obj;
    }

}



