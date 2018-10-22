package win.pub.srv;

import awin.bean.SuperVO;

import java.util.List;

/**
 * Created by aWin on 2018-09-07.
 */
public interface IChildrenQuery<C extends SuperVO> {

    List<C> queryByParentPk(String parentPk);
}
