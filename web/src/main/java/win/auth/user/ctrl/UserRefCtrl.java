package win.auth.user.ctrl;

import awin.dao.exception.DAOException;
import awin.dao.exception.FromParaNullException;
import awin.dao.persistence.type.SQLParameter;
import awin.dao.sql.util.SelectString;
import awin.logger.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import win.pub.ctrl.RefController;
import win.pub.ctrl.WinRefController;
import win.pub.model.RefModel;
import win.pub.srv.WinRefServer;

import java.util.List;

/**
 * Created by aWin on 2018-12-10.
 *
 * @Description:
 */
@Controller
@RequestMapping("doc/user")
public class UserRefCtrl extends RefController{

    private String pkval;
    public RefModel ref(String pkval)
    {
        this.pkval=pkval;
        return null;
    }

    protected String[] getTheadData() {
        return new String[]{"主键","用户编码","用户名称"};
    }

    protected String[] getDbField()
    {
        return new String[]{"pk_user","userCode","userName"};
    }

    protected String getTableName()
    {
        return "auth_user";
    }



    protected List<Object> getTbodyData() {
        SQLParameter parameter=new SQLParameter();
        parameter.addParam(pkval);
        try {
            SelectString sql=new SelectString().select(getDbField()).from(getTableName()).where(getDbField()[0]+"=? and dr='N'");
            List ret=getServer().query4List(sql.toString());
            return ret;
        } catch (FromParaNullException e) {
            Logger.Error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getDispVal(String pkval)
    {
        return getServer().getValue(getTableName(),getDbField()[1],getDbField()[0],pkval);
    }

    protected String getTitle() {
        return "用户信息";
    }


}
