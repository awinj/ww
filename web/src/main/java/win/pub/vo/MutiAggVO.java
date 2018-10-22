package win.pub.vo;

import awin.bean.SuperVO;

import java.util.*;

/**
 * Created by aWin on 2018-09-04.
 */
public abstract class MutiAggVO<P extends SuperVO> extends AggVO<P,SuperVO> {
    private P parentVO;

    private List<String> tabcodes;

    private Map<String,List<SuperVO>> allChildrenVO;

    public P getParentVO() {
        return parentVO;
    }

    public void setParentVO(P parentVO) {
        this.parentVO = parentVO;
    }

    public Map<String, List<SuperVO>> getAllChildrenVO() {
        return allChildrenVO;
    }

    public void setAllChildrenVO(Map<String, List<SuperVO>> allChildrenVO) {
        this.allChildrenVO = allChildrenVO;
    }


    public List<String> getTabcodes() {
        return tabcodes;
    }

    public void setTabcodes(List<String> tabcodes) {
        this.tabcodes = tabcodes;
    }

    public void addChild(String tabcode, SuperVO child)
    {
        if(allChildrenVO==null)
            allChildrenVO=new HashMap<String, List<SuperVO>>();
        List<SuperVO> children=allChildrenVO.get(tabcode);
        if(children==null)
            children=new ArrayList<SuperVO>();
        children.add(child);
    }

    public void addChild(String tabcode,List<SuperVO> child)
    {
        if(allChildrenVO==null)
            allChildrenVO=new HashMap<String, List<SuperVO>>();
        List<SuperVO> children=allChildrenVO.get(tabcode);
        if(children==null)
            children=new ArrayList<SuperVO>();
        children.addAll(child);
    }

    public List<SuperVO> getChildren(String tabcode)
    {
        if(allChildrenVO==null)
            return null;
        else
            return allChildrenVO.get(tabcode);
    }


    public List<SuperVO> getChildrenVO() {

        if(allChildrenVO!=null)
            return allChildrenVO.get("single");
        else
            return null;

    }

    public void setChildrenVO(List<SuperVO> childrenVO) {
        addChild("single",childrenVO);
    }
}
