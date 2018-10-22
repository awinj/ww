package win.pub.model;

import java.util.List;

/**
 * Created by aWin on 2018-10-09.
 */
public class RefModel {
    private String[] theadData;

    private List<Object> tbodyData;

    private String title;

    private boolean isMuti;


    public String[] getTheadData() {
        return theadData;
    }

    public void setTheadData(String[] theadData) {
        this.theadData = theadData;
    }

    public List<Object> getTbodyData() {
        return tbodyData;
    }

    public void setTbodyData(List<Object> tbodyData) {
        this.tbodyData = tbodyData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMuti() {
        return isMuti;
    }

    public void setMuti(boolean muti) {
        isMuti = muti;
    }
}
