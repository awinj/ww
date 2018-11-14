package win.pub.vo;

import awin.bean.SuperVO;
import win.auth.login.pub.LoginUtil;
import awin.util.date.DateUtil;

/**
 * Created by aWin on 2018-09-11.
 */
public abstract class DocVO extends SuperVO {

    protected String creator;

    protected String creationTime;

    protected String modifier;

    protected String modifyTime;


    public String getCreator() {
        if(creator==null||creator.length()<=0)
            return LoginUtil.getUserID();
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreationTime() {
        if(creationTime==null||creationTime.length()<=0)
            return DateUtil.getCurrentTime();
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
       this.creationTime = creationTime;
    }

    public String getModifier() {
        if(modifier==null||modifier.length()<=0)
            return LoginUtil.getUserID();
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        if(creationTime==null||creationTime.length()<=0)
            return DateUtil.getCurrentTime();
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
