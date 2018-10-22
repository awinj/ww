package win.auth.login.srv;

import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import win.auth.login.model.ChangePswdModel;
import win.auth.login.model.LoginModel;
import win.auth.user.vo.UserVO;
import win.pub.vo.BusinessException;

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

    public int login(LoginModel model) throws BusinessException
    {
        if(model!=null&&model.validate())
        {
            //TODO
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public int changePassword(ChangePswdModel model)
    {
        //TODO
        return 1;
    }

}
