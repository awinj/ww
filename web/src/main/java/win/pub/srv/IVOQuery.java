package win.pub.srv;

import awin.bean.SuperVO;
import win.auth.user.vo.UserVO;
import win.pub.model.PageModel;

import java.util.List;

/**
 * Created by aWin on 2018-09-07.
 */
public interface IVOQuery<P extends SuperVO> {

    /**
     *
     * @param model 分页模型
     * @return
     */
     List<P> query(PageModel model);

    P queryByPk(String pk);

}
