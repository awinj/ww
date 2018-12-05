package win.auth.login.srv;

import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import awin.dao.persistence.type.SQLParameter;
import awin.logger.Logger;
import awin.util.encrypt.MD5;
import win.auth.login.model.ChangePswdModel;
import win.auth.login.model.LoginModel;
import win.auth.power.vo.PowerVO;
import win.auth.user.vo.UserVO;
import win.pub.util.EncryptPassword;
import win.pub.vo.BusinessException;

import java.util.List;

/**
 * Created by aWin on 2018-09-07.
 */
public class LoginServer {

    BaseDAO baseDAO;

    private BaseDAO getDao() {
        if (baseDAO == null)
            baseDAO = new BaseDAO();
        return baseDAO;
    }

    public String login(LoginModel model) throws BusinessException {
        if (model != null && model.validate()) {
            //参数化，避免sql注入
            SQLParameter parameter = new SQLParameter();
            parameter.addParam(model.getUserName());
            try {
                List<UserVO> userVOs = getDao().queryByWhere(UserVO.class, " userCode=? ", parameter);
                if (userVOs == null || userVOs.size() < 1)
                    throw new BusinessException("用户名或密码错误");
                UserVO user = userVOs.get(0);
                //将用户输入的密码加密
                String encryptPassword= EncryptPassword.encrypt(model.getPassword());
                //判断加密后的密码是否与数据库密码一致
                if (encryptPassword.equals(user.getPassword()))
                    return user.getPk_user();
                else
                    throw new BusinessException("用户名或密码错误");
            } catch (DAOException e) {
                Logger.Error(e.getMessage(), e);
                throw new BusinessException(e.getMessage(), e);
            }
        }
        else
            throw new BusinessException("用户名或密码错误");

    }

    public int changePassword(ChangePswdModel model) {
        //TODO
        return 1;
    }

    public List<PowerVO> getPowerByUser(String userName) throws DAOException {
        SQLParameter parameter = new SQLParameter();
        parameter.addParam(userName);
        StringBuilder sql = new StringBuilder();
        sql.append(" select auth_power.*									        ");
        sql.append("   from auth_power                                      ");
        sql.append("  inner join auth_role_power                            ");
        sql.append("     on auth_power.pk_power = auth_role_power.pk_power  ");
        sql.append("  inner join auth_role                                  ");
        sql.append("     on auth_role.pk_role = auth_role_power.pk_role     ");
        sql.append("  inner join auth_user_role                             ");
        sql.append("     on auth_user_role.pk_role = auth_role.pk_role      ");
        sql.append("  inner join auth_user                                  ");
        sql.append("     on auth_user.pk_user = auth_user_role.pk_user      ");
        sql.append(" where   auth_user.pk_user=?                            ");
        List<PowerVO> powers=getDao().query(PowerVO.class, sql.toString(), parameter);
        return powers;
    }

}
