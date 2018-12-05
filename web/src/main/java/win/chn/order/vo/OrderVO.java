package win.chn.order.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class OrderVO extends SuperVO {

    private String pk_order ;
    private String title ;
    private String memeo ;
    private String amount ;
    private Integer state ;
    private String creator ;
    private String creationTime ;


    public String getPk_order() {
        return pk_order;
    }

    public void setPk_order(String pk_order) {
        this.pk_order = pk_order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemeo() {
        return memeo;
    }

    public void setMemeo(String memeo) {
        this.memeo = memeo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

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

    public String getTableName() {
        return "chn_order";
    }

    public String getPrimaryKey() {
        return "pk_order";
    }
}
