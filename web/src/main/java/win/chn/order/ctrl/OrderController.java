package win.chn.order.ctrl;

import win.chn.order.srv.OrderServer;
import win.chn.order.vo.OrderAggVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class OrderController extends BaseController<OrderAggVO> {
    public String query(String condition, Integer curr, Integer nums) {
        return null;
    }

    protected OrderServer getServer() {
        return new OrderServer();
    }
}
