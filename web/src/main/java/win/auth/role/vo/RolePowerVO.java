package win.auth.role.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-09-08.
 */
public class RolePowerVO extends SuperVO {


    private String pk_role_power;

    private String pk_role;

    private String pk_power;



    public String getTableName() {
        return "auth_role_power";
    }

    public String getPrimaryKey() {
        return "pk_role_power";
    }

    public String getParentPk() {
        return "pk_role";
    }
}
