package awin.lang;

import awin.util.parse.JsonUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by aWin on 2018-11-19.
 *
 * @Description:
 */
@JsonSerialize(using =BooleanExtSerializer.class)
@JsonDeserialize(using = BooleanExtDeserializer.class)
public class BooleanExt {

    public static final BooleanExt TRUE = new BooleanExt(true);

    public static final BooleanExt FALSE = new BooleanExt(false);
    private boolean value = false;

    public BooleanExt(char ch)
    {
        this.value = ((ch == 'Y') || (ch == 'y'));
    }

    public BooleanExt(String val)
    {
        if ((val != null) && (val.length() > 0) && ((val.equalsIgnoreCase("true")) || (val.charAt(0) == 'Y') || (val.charAt(0) == 'y')))
        {
            this.value = true;
        }
        else this.value = false;
    }

    public BooleanExt(boolean b)
    {
        this.value = b;
    }

    public boolean booleanValue()
    {
        return this.value;
    }

    public static BooleanExt valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }

    public static BooleanExt valueOf(String val) {
        if ((val != null) && (val.length() > 0) && ((val.equalsIgnoreCase("true")) || (val.charAt(0) == 'Y') || (val.charAt(0) == 'y')))
        {
            return TRUE;
        }
        return FALSE;
    }

    public boolean equals(Object obj)
    {
        if ((obj != null) && ((obj instanceof BooleanExt))) {
            return this.value == ((BooleanExt)obj).booleanValue();
        }
        return false;
    }

    public int hashCode()
    {
        return this.value ? 1231 : 1237;
    }

    public String toString()
    {
        return this.value ? "Y" : "N";
    }

    public int compareTo(Object o)
    {
        if (o == null) return 1;
        return toString().compareTo(o.toString());
    }


    public static void main(String[] args)
    {
        BooleanExt b=new BooleanExt(false);
        BooleanExt b1=new BooleanExt(false);
        BooleanExt b2=new BooleanExt(false);
        System.out.println(JsonUtil.beanToJson("fsfd"));
//        System.out.println(JsonUtil.beanToJson(new BooleanExt[]{b,b1,b2}));

        Object obj= JsonUtil.jsonToBean("[\"N\",\"N\",\"N\"]",BooleanExt[].class);

//        BooleanExt b=new BooleanExt(false);
//        BooleanExt b1=new BooleanExt(false);
//        BooleanExt b2=new BooleanExt(false);
        System.out.println(JsonUtil.beanToJson("fsfd"));
    }
}
