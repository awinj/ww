package win.chn.rsur.ctrl;

import win.chn.rsur.srv.ResourceServer;
import win.chn.rsur.vo.ResourceAggVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class ResourceController extends BaseController<ResourceAggVO> {
    public String query(String condition, Integer curr, Integer nums) {
        return null;
    }

    protected ResourceServer getServer() {
        return new ResourceServer();
    }
}
