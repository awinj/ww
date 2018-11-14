package win.auth.power.vo;

import win.pub.vo.AggVO;

import java.util.List;

/**
 * Created by aWin on 2018-11-14.
 */
public class PowerAggVO extends AggVO<PowerVO,PowerVO> {

    //单表，不需要子表
    public List<PowerVO> getChildrenVO() {
        return null;
    }
}
