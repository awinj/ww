package win.pub.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-09-11.
 */
public abstract class DocVO extends SuperVO {

    protected String creator;

    protected String creationTime;

    protected String modifier;

    protected String modifyTime;


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
