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


    public String getPk_role_power() {
        return pk_role_power;
    }

    public void setPk_role_power(String pk_role_power) {
        this.pk_role_power = pk_role_power;
    }

    public String getPk_role() {
        return pk_role;
    }

    public void setPk_role(String pk_role) {
        this.pk_role = pk_role;
    }

    public String getPk_power() {
        return pk_power;
    }

    public void setPk_power(String pk_power) {
        this.pk_power = pk_power;
    }
}
