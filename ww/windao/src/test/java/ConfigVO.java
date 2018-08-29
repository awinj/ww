import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-08-10.
 */
public class ConfigVO extends SuperVO {

    private String systemcode;
    private String parakey;
    private String paravalue;


    public String getSystemcode() {
        return systemcode;
    }

    public void setSystemcode(String systemcode) {
        this.systemcode = systemcode;
    }

    public String getParakey() {
        return parakey;
    }

    public void setParakey(String parakey) {
        this.parakey = parakey;
    }

    public String getParavalue() {
        return paravalue;
    }

    public void setParavalue(String paravalue) {
        this.paravalue = paravalue;
    }

    public String getTableName() {
        return "mid_config";
    }

    public String getPrimaryKey() {
        return "systemcode";
    }
}
