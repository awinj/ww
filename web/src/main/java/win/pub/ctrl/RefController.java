package win.pub.ctrl;

import win.pub.model.RefModel;
import win.pub.srv.PubServer;
import win.pub.srv.WinRefServer;

import java.util.List;

/**
 * Created by aWin on 2018-10-09.
 */
public abstract class RefController {

    protected abstract String[] getTheadData();

    protected abstract List<Object> getTbodyData();

    protected abstract String getTitle();

    protected  boolean isMuti()
    {
        return false;
    }


    public RefModel refdata()
    {
        RefModel model=new RefModel();
        model.setMuti(isMuti());
        model.setTbodyData(getTbodyData());
        model.setTheadData(getTheadData());
        model.setTitle(getTitle());
        return model;
    }

    protected WinRefServer getServer()
    {
        return new WinRefServer();
    }
}
