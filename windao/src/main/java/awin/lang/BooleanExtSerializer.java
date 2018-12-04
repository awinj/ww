package awin.lang;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * json  序列化
 * @author aWin
 */
public class BooleanExtSerializer extends JsonSerializer<BooleanExt> {

    public void serialize(BooleanExt booleanExt, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(booleanExt.toString());
    }
}
