package win.auth.role.vo;

import win.pub.util.table.IMapMeta;

/**
 * Created by aWin on 2018-11-25.
 *
 * @Description:
 */
public class RoleMapMeta implements IMapMeta{
    public String[] getFieldNames() {
        return new String[]{"roleCode","roleName","memo"};
    }

    public String[] getFieldDisplayNames() {
        return new String[]{"角色编码","角色名称","备注"};
    }
}
