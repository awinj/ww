package win.auth.user.srv;

import awin.bean.SuperVO;
import awin.dao.exception.DAOException;
import awin.dao.persistence.type.SQLParameter;
import awin.logger.Logger;
import win.auth.user.vo.UserRoleVO;
import win.auth.user.vo.UserVO;
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
//TODO
public class UserServer extends PubServer implements IVOQuery<UserVO>,IChildrenQuery<UserRoleVO> {


    /**
     * 锁定用户
     * @param vo 用户实体，用户名，用户编码，用户主键至少一个值有数据
     */
    public void lockUser(UserVO vo)
    {

    }







    public UserVO queryByPk(String pk) {
        return null;
    }




    public List<UserRoleVO> queryByParentPk(String parentPk) {
        return null;
    }


    public UserVO queryByUserName(String userName)
    {
        return null;
    }

    public UserVO queryByUserCode(String userCode)
    {
        return null;
    }


    public UserVO queryByCodeOrName(String codeOrName)
    {
        return null;
    }


    public boolean assign(String pk_user, List<String> roles) throws BusinessException {
        if (pk_user == null)
            throw new BusinessException("未选择用户");
        try {
            SQLParameter parameter = new SQLParameter();
            parameter.addParam(pk_user);
            //先将用户已有的角色删除
            getDao().deleteByWhere(UserRoleVO.class," pk_user=?",parameter);
            List<UserRoleVO> userRoleVOs = new ArrayList<UserRoleVO>();
            if (roles != null&&roles.size()>0) {
                for (String role : roles) {
                    UserRoleVO userRoleVO = new UserRoleVO();
                    userRoleVO.setPk_user(pk_user);
                    userRoleVO.setPk_role(role);
                    userRoleVOs.add(userRoleVO);
                }
            }
            //再新增此次分配的角色
            getDao().insert(userRoleVOs.toArray(new UserRoleVO[0]));
        } catch (DAOException e) {
            Logger.Error(e.getMessage(), e);
            throw new BusinessException(e.getMessage(), e);
        }
        return true;
    }


//    public List<PowerVO> getPowerPowerByUser(String userName) throws DAOException {
//        SQLParameter parameter=new SQLParameter();
//        parameter.addParam(userName);
//        StringBuilder sql=new StringBuilder();
//        sql.append(" select auth_power.*									        ");
//        sql.append("   from auth_power                                      ");
//        sql.append("  inner join auth_role_power                            ");
//        sql.append("     on auth_power.pk_power = auth_role_power.pk_power  ");
//        sql.append("  inner join auth_role                                  ");
//        sql.append("     on auth_role.pk_role = auth_role_power.pk_role     ");
//        sql.append("  inner join auth_user_role                             ");
//        sql.append("     on auth_user_role.pk_role = auth_role.pk_role      ");
//        sql.append("  inner join auth_user                                  ");
//        sql.append("     on auth_user.pk_user = auth_user_role.pk_user      ");
//        sql.append(" where   username=?                                     ");
//        getDao().query(PowerVO.class,"",parameter);
//        return null;
//    }
}
