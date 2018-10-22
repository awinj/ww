package win.auth.role.vo;

import win.pub.vo.DocVO;

/**
 * Created by aWin on 2018-09-07.
 */
public class RoleVO extends DocVO {

    private String pk_role;

    private String roleName;

    private String roleCode;

    /**
     * 角色描述，可空
     */
    private String roleMemo;


    public String getTableName() {
        return "auth_role";
    }

    public String getPrimaryKey() {
        return "pk_role";
    }


}
