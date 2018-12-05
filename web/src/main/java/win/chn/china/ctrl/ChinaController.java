package win.chn.china.ctrl;

import win.chn.china.srv.ChinaServer;
import win.chn.china.vo.ChinaAggVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class ChinaController extends BaseController<ChinaAggVO> {

    public String query(String condition, Integer curr, Integer nums) {
        return null;
    }

    protected ChinaServer getServer() {
        return new ChinaServer();
    }
}
