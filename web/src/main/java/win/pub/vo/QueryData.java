package win.pub.vo;

import awin.bean.SuperVO;

import java.util.List;

/**
 * Created by aWin on 2018-10-22.
 */
public class QueryData {
    private String code;
    private String msg;
    private int count;
    private List data;


    public QueryData()
    {
        code="0";
        msg="";
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
