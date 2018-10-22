package win.pub.vo;

/**
 * Created by aWin on 2018-09-04.
 */
public class Result {
    private String code;
    private String msg;
    private int statue;
    private Object data;


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

    /**
     * 0-无异常，1-表示有异常
     * @return 0-无异常，1-表示有异常
     */
    public int getStatue() {
        return statue;
    }

    /**
     * 0-无异常，1-表示有异常
     * @param statue 0-无异常，1-表示有异常
     */
    public void setStatue(int statue) {
        this.statue = statue;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
