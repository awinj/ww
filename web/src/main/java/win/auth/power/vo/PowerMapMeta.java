package win.auth.power.vo;

import win.pub.util.table.IMapMeta;

/**
 * Created by aWin on 2018-12-02.
 *
 * @Description:
 */
public class PowerMapMeta implements IMapMeta {
    public String[] getFieldNames() {
        return new String[]{"powerCode","powerName","memo"};
    }

    public String[] getFieldDisplayNames() {
        return new String[]{"编码","名称","备注"};
    }
}
