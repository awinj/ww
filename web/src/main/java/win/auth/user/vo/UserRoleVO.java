package win.auth.user.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-09-07.
 */
public class UserRoleVO extends SuperVO {

    private String pk_user_role;

    private String pk_user;

    private String pk_role;



    public String getTableName() {
        return "auth_user_role";
    }

    public String getPrimaryKey() {
        return "pk_user_role";
    }

    @Override
    public String getParentPk() {
        return "pk_user";
    }


    public String getPk_user_role() {
        return pk_user_role;
    }

    public void setPk_user_role(String pk_user_role) {
        this.pk_user_role = pk_user_role;
    }

    public String getPk_user() {
        return pk_user;
    }

    public void setPk_user(String pk_user) {
        this.pk_user = pk_user;
    }

    public String getPk_role() {
        return pk_role;
    }

    public void setPk_role(String pk_role) {
        this.pk_role = pk_role;
    }
}
