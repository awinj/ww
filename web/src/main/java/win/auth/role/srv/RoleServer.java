package win.auth.role.srv;

import awin.dao.exception.DAOException;
import awin.dao.persistence.type.SQLParameter;
import awin.logger.Logger;
import win.auth.role.vo.RolePowerVO;
import win.auth.role.vo.RoleVO;
import win.pub.model.PageModel;
import win.pub.srv.IChildrenQuery;
import win.pub.srv.IVOQuery;
import win.pub.srv.PubServer;
import win.pub.vo.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-09-07.
 */
public class RoleServer extends PubServer implements IVOQuery<RoleVO>,IChildrenQuery<RolePowerVO> {


    public RoleVO queryByPk(String pk) {
        return null;
    }

    public List<RolePowerVO> queryByParentPk(String parentPk) {
        return null;
    }


    public boolean assign(String pk_role, List<String> powers) throws BusinessException {
        if (pk_role == null)
            throw new BusinessException("未选择角色");
        try {
            SQLParameter parameter = new SQLParameter();
            parameter.addParam(pk_role);
            //先将角色已有的功能删除
            getDao().deleteByWhere(RolePowerVO.class," pk_user=?",parameter);
            List<RolePowerVO> userRoleVOs = new ArrayList<RolePowerVO>();
            if (powers != null) {
                for (String power : powers) {
                    RolePowerVO userRoleVO = new RolePowerVO();
                    userRoleVO.setPk_power(power);
                    userRoleVO.setPk_role(pk_role);
                    userRoleVOs.add(userRoleVO);
                }
            }
            //再新增此次分配的角色
            getDao().insert(userRoleVOs.toArray(new RolePowerVO[0]));
        } catch (DAOException e) {
            Logger.Error(e.getMessage(), e);
            throw new BusinessException(e.getMessage(), e);
        }
        return true;
    }
}
