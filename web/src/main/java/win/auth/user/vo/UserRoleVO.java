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
}
