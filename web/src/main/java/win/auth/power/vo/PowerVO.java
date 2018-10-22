package win.auth.power.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-09-08.
 */
public  class PowerVO extends SuperVO {

    private String pk_power;

    private String powerCode;

    private String powerName;

    /**
     * 资源类型，0（功能）
     */
    private String powerType;

    /**
     * 资源描述，可空
     */
    private String powerMemo;


    public String getTableName() {
        return "auth_power";
    }

    public String getPrimaryKey() {
        return "pk_power";
    }

}
