package win.auth.power.vo;

import awin.bean.SuperVO;
import awin.lang.BooleanExt;

/**
 * Created by aWin on 2018-09-08.
 */
public  class PowerVO extends SuperVO {

    private String pk_power ;
    private String powerCode ;
    private String powerName ;
    private String powerType ;
    private String url ;
    private String memo ;
    private BooleanExt enable ;



    public String getTableName() {
        return "auth_power";
    }

    public String getPrimaryKey() {
        return "pk_power";
    }


    public String getPk_power() {
        return pk_power;
    }

    public void setPk_power(String pk_power) {
        this.pk_power = pk_power;
    }

    public String getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(String powerCode) {
        this.powerCode = powerCode;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BooleanExt getEnable() {
        return enable;
    }

    public void setEnable(BooleanExt enable) {
        this.enable = enable;
    }
}
