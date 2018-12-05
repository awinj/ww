package win.pst.post.ctrl;

import com.fasterxml.jackson.databind.deser.Deserializers;
import win.pst.post.srv.PostServer;
import win.pst.post.vo.PostAggVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class PostController extends BaseController<PostAggVO> {
    public String query(String condition, Integer curr, Integer nums) {
        return null;
    }

    protected PostServer getServer() {
        return new PostServer();
    }
}
