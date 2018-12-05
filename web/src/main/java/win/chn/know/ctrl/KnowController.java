package win.chn.know.ctrl;

import win.chn.know.srv.KnowServer;
import win.chn.know.vo.KnowAggVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class KnowController extends BaseController<KnowAggVO> {
    public String query(String condition, Integer curr, Integer nums) {
        return null;
    }

    protected KnowServer getServer() {
        return new KnowServer();
    }
}
