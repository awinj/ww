package awin.dao.persistence.type;

import awin.logger.Logger;

import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * Clob类型
 * User: 贺扬
 * Date: 2005-5-16
 * Time: 16:39:24
 * ClobParamType类的说明
 */
public class ClobParamType  implements  SQLParamType{
    /**
     * <code>serialVersionUID</code> 的注释
     */
    private static final long serialVersionUID = 2091823985828181145L;
    String s = null;
    int length = 0;
    Reader reader = null;

    public ClobParamType(String s) {
        try {
            this.s = s;
            length = s.getBytes("iso8859-1").length;
        } catch (UnsupportedEncodingException e) {
            Logger.Error(e.getMessage(),e);
        }
    }

    public ClobParamType(Reader read, int length) {
        this.reader = read;
        this.length = length;
    }

    public Reader getReader() {
        if (reader == null) {
            reader = new StringReader(s);
        }
        return reader;
    }

    public int getLength() {
        return length;
    }


}
