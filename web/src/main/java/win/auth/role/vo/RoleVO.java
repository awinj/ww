package win.auth.role.vo;

import awin.bean.pub.BooleanExt;
import win.pub.vo.DocVO;

/**
 * Created by aWin on 2018-09-07.
 */
public class RoleVO extends DocVO {

    private String pk_role ;
    private String roleCode ;
    private String roleName ;
    private String roleType ;
    private String memo ;
    private BooleanExt enable ;


    public String getPk_role() {
        return pk_role;
    }

    public void setPk_role(String pk_role) {
        this.pk_role = pk_role;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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

    public String getTableName() {
        return "auth_role";
    }

    public String getPrimaryKey() {
        return "pk_role";
    }


}
