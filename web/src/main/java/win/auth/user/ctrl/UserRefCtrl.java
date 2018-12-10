package win.auth.user.ctrl;

import awin.dao.exception.DAOException;
import awin.dao.persistence.type.SQLParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import win.pub.ctrl.RefController;
import win.pub.model.RefModel;

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

    protected List<Object> getTbodyData() {
        SQLParameter parameter=new SQLParameter();
        parameter.addParam(pkval);
        try {
            List ret=getServer().query4List("select pk_user,userCode,userName from auth_user where pk_user=?",parameter);
            return ret;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getTitle() {
        return "用户信息";
    }


}
