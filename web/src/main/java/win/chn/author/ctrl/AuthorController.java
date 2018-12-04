package win.chn.author.ctrl;

import win.chn.author.srv.AuthorServer;
import win.chn.author.vo.AuthorAggVO;
import win.chn.author.vo.AuthorVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
public class AuthorController extends BaseController<AuthorAggVO> {
    public String query(String condition, Integer curr, Integer nums) {
        return super.queryData(AuthorVO.class,condition,curr,nums);
    }



    @Override
    protected AuthorServer getServer()
    {
        return new AuthorServer();
    }
}
