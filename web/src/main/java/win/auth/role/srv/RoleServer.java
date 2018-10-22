package win.auth.role.srv;

import win.auth.role.vo.RolePowerVO;
import win.auth.role.vo.RoleVO;
import win.pub.model.PageModel;
import win.pub.srv.IChildrenQuery;
import win.pub.srv.IVOQuery;
import win.pub.srv.PubServer;

import java.util.List;

/**
 * Created by aWin on 2018-09-07.
 */
public class RoleServer extends PubServer implements IVOQuery<RoleVO>,IChildrenQuery<RolePowerVO> {

    public List<RoleVO> query(PageModel model) {
        return null;
    }

    public RoleVO queryByPk(String pk) {
        return null;
    }

    public List<RolePowerVO> queryByParentPk(String parentPk) {
        return null;
    }
}
