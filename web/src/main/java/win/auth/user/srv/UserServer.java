package win.auth.user.srv;

import win.auth.power.vo.PowerVO;
import win.auth.user.vo.UserRoleVO;
import win.auth.user.vo.UserVO;
import win.pub.model.PageModel;
import win.pub.srv.IChildrenQuery;
import win.pub.srv.IVOQuery;
import win.pub.srv.PubServer;

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

    public List<UserVO> query(PageModel model)
    {
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

    public List<PowerVO> getFuncPowerByUser(String userName)
    {
        return null;
    }
}
