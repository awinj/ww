package win.chn.order.vo;

import awin.bean.SuperVO;

import java.math.BigDecimal;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class OrderBVO extends SuperVO {

    private String pk_order_b ;
    private String pk_order ;
    private String pk_resource ;
    private String name ;
    private String content ;
    private String endtime ;
    private BigDecimal price ;
    private BigDecimal num ;
    private BigDecimal amount ;
    private String creator ;
    private String creationTime ;


    public String getPk_order_b() {
        return pk_order_b;
    }

    public void setPk_order_b(String pk_order_b) {
        this.pk_order_b = pk_order_b;
    }

    public String getPk_order() {
        return pk_order;
    }

    public void setPk_order(String pk_order) {
        this.pk_order = pk_order;
    }

    public String getPk_resource() {
        return pk_resource;
    }

    public void setPk_resource(String pk_resource) {
        this.pk_resource = pk_resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
        return "chn_order_b";
    }

    public String getPrimaryKey() {
        return "pk_order_b";
    }
}
