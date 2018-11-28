package win.auth.login.srv;

import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import awin.dao.persistence.type.SQLParameter;
import win.auth.login.model.ChangePswdModel;
import win.auth.login.model.LoginModel;
import win.auth.power.vo.PowerVO;
import win.auth.user.vo.UserVO;
import win.pub.vo.BusinessException;

import java.util.List;

/**
 * Created by aWin on 2018-09-07.
 */
public class LoginServer {

    BaseDAO baseDAO;
    private BaseDAO getDao()
    {
        if(baseDAO==null)
            baseDAO=new BaseDAO();
        return baseDAO;
    }

    public String login(LoginModel model) throws BusinessException
    {
        if(model!=null&&model.validate())
        {
            //TODO

            return "1";
        }
        else
        {
            return "0";
        }
    }

    public int changePassword(ChangePswdModel model)
    {
        //TODO
        return 1;
    }

    public List<PowerVO> getPowerByUser(String userName) throws DAOException {
        SQLParameter parameter=new SQLParameter();
        parameter.addParam(userName);
        StringBuilder sql=new StringBuilder();
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
        sql.append(" where   username=?                                     ");
        getDao().query(PowerVO.class,sql.toString(),parameter);
        return null;
    }

}
