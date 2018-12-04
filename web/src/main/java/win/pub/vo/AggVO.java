package win.pub.vo;

import awin.bean.SuperVO;

import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2018-09-04.
 */
public  class AggVO<P extends SuperVO,C extends SuperVO> {

    private P parentVO;

    private List<C> childrenVO;


    public P getParentVO() {
        return parentVO;
    }

    public void setParentVO(P parentVO) {
        this.parentVO = parentVO;
    }

    public List<C> getChildrenVO() {
        return childrenVO;
    }

    public void setChildrenVO(List<C> childrenVO) {
        this.childrenVO = childrenVO;
    }
}
