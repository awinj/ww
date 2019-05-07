package awin.lang;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;


/**
 * json 反序列化
 * @author aWin
 */
public class BooleanExtDeserializer extends JsonDeserializer<BooleanExt> {
    public BooleanExt deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return new BooleanExt(jsonParser.getText());
    }


}
